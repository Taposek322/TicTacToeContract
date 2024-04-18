package com.taposek322.tictactoecontract.presentation.game.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.domain.util.ActionsValue
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigInteger
import javax.inject.Inject

private const val TAG = "TicTacViewModel"

@HiltViewModel
class TicTacToeViewmodel @Inject constructor(
    private val rep:EtherRepository
): ViewModel() {

    private var _data:MutableList<ActionsValue?>  = MutableList(9){null}

    private var _state: MutableStateFlow<List<ActionsValue?>> = MutableStateFlow(
        _data.toList()
    )
    val state = _state.asStateFlow()

    var error by mutableStateOf(false)
        private set


    private var errorChannel = Channel<UiText>()
    val errorMessage = errorChannel.receiveAsFlow()

    fun set(position:BigInteger){
        error = false
        CoroutineScope(Dispatchers.IO).launch{
            val result = rep.makeMove(
                position = position
            )
            when(result){
                is Resource.Success->{

                }
                is Resource.Error->{
                    errorChannel.send(result.message?:UiText.StringResource(R.string.unknown_error_message))
                    error = true
                }
            }
        }
    }
    /*
    /*TODO удалить после релизации репозитория*/
    private var flag = true

    fun set(position:Int){
        Log.d(TAG, "In set")
        val action = if(flag){
            ActionsValue.XS
        }else{
            ActionsValue.OS
        }
        Log.d(TAG, "Action:$action")
        flag = !flag
        CoroutineScope(Dispatchers.IO).launch {
            _data[i][j] = action
            _state.update {
                _data.map { it.toList() }.toList()
            }
            Log.d(TAG, "_Data:$_data")
        }
    }
    */
}