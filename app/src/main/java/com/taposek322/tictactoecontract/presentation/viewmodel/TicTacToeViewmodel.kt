package com.taposek322.tictactoecontract.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.taposek322.tictactoecontract.domain.ActionsValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "TicTacViewModel"
class TicTacToeViewmodel:ViewModel() {

    private var _data:MutableList<MutableList<ActionsValue?>>  = MutableList(3){MutableList(3){null} }

    private var _state:MutableStateFlow<List<List<ActionsValue?>>>  = MutableStateFlow(
        _data.map { it.toList() }.toList()
    )
    val state = _state.asStateFlow()

    /*TODO удалить после релизации репозитория*/
    private var flag = true

    fun set(i:Int,j:Int){
        Log.d(TAG,"In set")
        val action = if(flag){ActionsValue.XS}else{ActionsValue.OS}
        Log.d(TAG,"Action:$action")
        flag = !flag
        CoroutineScope(Dispatchers.IO).launch {
            _data[i][j] = action
            _state.update {
                _data.map { it.toList() }.toList()
            }
            Log.d(TAG,"_Data:$_data")
        }
    }

}