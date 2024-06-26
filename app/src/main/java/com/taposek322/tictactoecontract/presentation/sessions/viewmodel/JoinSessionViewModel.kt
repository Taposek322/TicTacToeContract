package com.taposek322.tictactoecontract.presentation.sessions.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.domain.validation.ValidationClass
import com.taposek322.tictactoecontract.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinSessionViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val rep: EtherRepository,
    private val validation:ValidationClass
): ViewModel() {

    var contractAddress by mutableStateOf("")
        private set
    var contractAddressErrorMessage:String? by mutableStateOf(null)
        private set

    var ethAmount by mutableStateOf("")
        private set
    var ethAmountErrorMessage:String? by mutableStateOf(null)
        private set

    var success by mutableStateOf(false)
        private set

    var error by mutableStateOf(false)
        private set

    var loading by mutableStateOf(false)
        private set

    private var errorChannel = Channel<UiText>()
    val errorMessage = errorChannel.receiveAsFlow()

    private fun subscribeToSecondPlayerJoinGame(){
        rep.subscribeToPlayer2JoinedEvents({
            success = true
        })
    }
    fun changeContractAddress(value:String){
        contractAddress = value
    }

    fun changeEthAmount(value:String){
        ethAmount = value
    }

    fun joinGame(){
        error = false
        success = false
        loading = true

        contractAddressErrorMessage = null
        ethAmountErrorMessage = null
        val contractAddressError = validation.validateEmptyString(contractAddress)
        var ethAmountError = validation.validateEmptyString(ethAmount)
        if (ethAmountError is Resource.Success){
            ethAmountError = validation.validateNumberField(ethAmount)
        }
        val hasError = listOf(
            contractAddressError,
            ethAmountError,
        ).any {
            it is Resource.Error
        }
        if(hasError){
            contractAddressErrorMessage = contractAddressError.message?.asString(context = context)
            ethAmountErrorMessage = ethAmountError.message?.asString(context = context)
            loading = false
        }else {
            val joinJob = CoroutineScope(Dispatchers.IO).launch {
                val loadContractRes: Resource<UiText> = rep.connectToContract(contractAddress)
                when (loadContractRes) {
                    is Resource.Success -> {
                        subscribeToSecondPlayerJoinGame()
                        val joinGameRes =
                            rep.joinGame(contractAddress, ethAmount.toBigDecimal())
                        if(joinGameRes  is Resource.Error) {
                            errorChannel.send(
                                joinGameRes.message
                                    ?: UiText.StringResource(R.string.unknown_error_message)
                            )
                            error = true;
                        }
                    }
                    is Resource.Error -> {
                        errorChannel.send(
                            loadContractRes.message
                                ?: UiText.StringResource(R.string.unknown_error_message)
                        )
                        error = true;
                    }
                }
            }
            val cancelJob = CoroutineScope(Dispatchers.IO).launch {
                delay(120000)
                joinJob.cancel()
                error = true
                errorChannel.send(
                    UiText.StringResource(R.string.timeout_exception_message)
                )
            }
            viewModelScope.launch {
                joinJob.join()
                cancelJob.join()
                loading = false
            }
        }
    }

    fun clear(){
        error = false
        success = false
        loading = false
    }
}