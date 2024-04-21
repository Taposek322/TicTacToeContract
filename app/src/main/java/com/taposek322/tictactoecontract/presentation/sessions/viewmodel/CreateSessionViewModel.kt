package com.taposek322.tictactoecontract.presentation.sessions.viewmodel

import android.annotation.SuppressLint
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
import org.jetbrains.annotations.Async.Schedule
import javax.inject.Inject

//@SuppressLint("CheckResult")
@HiltViewModel
class CreateSessionViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val rep:EtherRepository,
    private val validation:ValidationClass
): ViewModel() {
    var expectedPlayer2 by mutableStateOf("")
        private set
    var expectedPlayer2ErrorMessage:String? by mutableStateOf(null)
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

    fun changeExpectedPlayer(value:String){
        expectedPlayer2 = value
    }

    fun changeEthAmount(value:String){
        ethAmount = value
    }

    fun createGame(){
        error = false
        success = false
        loading = true

        expectedPlayer2ErrorMessage = null
        ethAmountErrorMessage = null
        val expectedPlayer2Error = validation.validateEmptyString(expectedPlayer2)
        var ethAmountError = validation.validateEmptyString(ethAmount)
        if (ethAmountError is Resource.Success){
            ethAmountError = validation.validateNumberField(ethAmount)
        }
        val hasError = listOf(
            expectedPlayer2Error,
            ethAmountError,
        ).any {
            it is Resource.Error
        }
        if(hasError){
            expectedPlayer2ErrorMessage = expectedPlayer2Error.message?.asString(context = context)
            ethAmountErrorMessage = ethAmountError.message?.asString(context = context)
            loading = false
        }else {
            val createJob = CoroutineScope(Dispatchers.IO).launch {
                val createContractRes = rep.createContract()
                when (createContractRes) {
                    is Resource.Success -> {
                        val createGameResult =
                            rep.createGame(expectedPlayer2, ethAmount.toBigDecimal())
                        when (createGameResult) {
                            is Resource.Success -> {
                                success = true
                            }

                            is Resource.Error -> {
                                errorChannel.send(
                                    createGameResult.message ?: UiText.StringResource(
                                        R.string.unknown_error_message
                                    )
                                )
                                error = true;
                            }
                        }
                    }

                    is Resource.Error -> {
                        errorChannel.send(
                            createContractRes.message
                                ?: UiText.StringResource(R.string.unknown_error_message)
                        )
                        error = true;
                    }
                }
            }
            val cancelJob = CoroutineScope(Dispatchers.IO).launch {
                delay(120000)
                createJob.cancel()
                error = true
                errorChannel.send(
                    UiText.StringResource(R.string.timeout_exception_message)
                )
            }
            viewModelScope.launch {
                createJob.join()
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