package com.taposek322.tictactoecontract.presentation.sessions.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionWaitSecondPlayerViewModel @Inject constructor(
    private val rep:EtherRepository
):ViewModel() {
    var success by mutableStateOf(false)
        private set

    var contractAddress by mutableStateOf("")
        private set

    init {
        getContractAddress()
    }
    private fun getContractAddress(){
        contractAddress = rep.getContractAddress()
    }

    fun clear(){
        success = false
    }
}