package com.taposek322.tictactoecontract.presentation.sessions.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionWaitSecondPlayerViewModel @Inject constructor(
    private val rep:EtherRepository
):ViewModel() {
    var success by mutableStateOf(false)
        private set

    var error by mutableStateOf(false)
        private set

    var contractAddress by mutableStateOf("")
        private set

    private var errorChannel = Channel<UiText>()
    val errorMessage = errorChannel.receiveAsFlow()

    init {
        getContractAddress()
        CoroutineScope(Dispatchers.IO).launch {
            rep.subscribeToPlayer2JoinedEvents({
                success = true
            })
        }
    }

    private fun getContractAddress(){
        contractAddress = rep.getContractAddress()
    }

    fun clear(){
        success = false
        error = false
    }
}