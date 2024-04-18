package com.taposek322.tictactoecontract.presentation.sessions.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.presentation.sessions.ui.JoinSessionState
import com.taposek322.tictactoecontract.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class JoinSessionViewModel @Inject constructor(
    private val rep: EtherRepository
): ViewModel() {

    var contractAddress by mutableStateOf("")
        private set

    var ethAmount by mutableStateOf("")
        private set

    var success by mutableStateOf(false)
        private set

    var error by mutableStateOf(false)
        private set

    var loading by mutableStateOf(false)
        private set

    private var errorChannel = Channel<UiText>()
    val errorMessage = errorChannel.receiveAsFlow()

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
        CoroutineScope(Dispatchers.IO).launch {
            val loagContractRes = rep.connectToContract(contractAddress)
            when(loagContractRes){
                is Resource.Success ->{
                    val joinGameRes = rep.joinGame(contractAddress, ethAmount.toBigDecimal())
                    when(joinGameRes){
                        is Resource.Success ->{
                            success = true
                        }
                        is Resource.Error->{
                            errorChannel.send(joinGameRes.message?: UiText.StringResource(R.string.unknown_error_message))
                            error = true;
                        }
                    }

                }
                is Resource.Error->{
                    errorChannel.send(loagContractRes.message?: UiText.StringResource(R.string.unknown_error_message))
                    error = true;
                }
            }
            loading = false
        }
    }

    fun clear(){
        error = false
        success = false
        loading = false
    }
}