package com.taposek322.tictactoecontract.presentation.sessions.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateSessionViewModel @Inject constructor(
    private val rep:EtherRepository
): ViewModel() {

    var expectedPlayer2 by mutableStateOf("")
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
        CoroutineScope(Dispatchers.IO).launch {
            val createContractRes = rep.createContract()
            when(createContractRes){
                is Resource.Success ->{
                    val createGameResult = rep.createGame(expectedPlayer2, ethAmount.toBigDecimal())
                    when(createGameResult){
                        is Resource.Success ->{
                           success = true
                        }
                        is Resource.Error->{
                            errorChannel.send(createGameResult.message?:UiText.StringResource(R.string.unknown_error_message))
                            error = true;
                        }
                    }
                }
                is Resource.Error->{
                    errorChannel.send(createContractRes.message?:UiText.StringResource(R.string.unknown_error_message))
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