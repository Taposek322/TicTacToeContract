package com.taposek322.tictactoecontract.presentation.game.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.domain.gamefield.ActionsValue
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.web3j.abi.datatypes.Address
import java.math.BigInteger
import javax.inject.Inject

private const val TAG = "TicTacViewModel"

@HiltViewModel
class TicTacToeViewmodel @Inject constructor(
    private val rep:EtherRepository
): ViewModel() {

    //private var _data:MutableList<ActionsValue?>  = MutableList(9){null}

    /*private var _state: MutableStateFlow<List<ActionsValue?>> = MutableStateFlow(
        MutableList(9){null}
    )
    val state = _state.asStateFlow()*/

    private var _gamefield:MutableList<ActionsValue?> = MutableList(9){null}
    var gamefield by mutableStateOf(
        _gamefield.toList()
    )
        private set

    var loading by mutableStateOf(false)
        private set

    var error by mutableStateOf(false)
        private set

    private val playerAddress = rep.getPlayerAddress()

    var whosTurn by mutableStateOf(false)
        private set

    private var errorChannel = Channel<UiText>()
    val errorMessage = errorChannel.receiveAsFlow()

    var gameFinished by mutableStateOf(false)
        private set

    var winner:GameResult by mutableStateOf(GameResult.Draw)
        private set

    var betAmount:Long by mutableLongStateOf(0)
        private set

    init {
        CoroutineScope(Dispatchers.IO).launch {
            whosTurnDefine()
        }
        CoroutineScope(Dispatchers.IO).launch {
            rep.subscribeToMoveMadeEvents { gm ->
                _gamefield[gm.position] = gm.action
                gamefield = _gamefield.toList()
                CoroutineScope(Dispatchers.IO).launch {
                    whosTurnDefine()
                }
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            rep.subscribeToGameFinishedEvents { winnerAddress, bet ->
                gameFinished = true
                Log.d("Tictacviewmode","Winner address:$winnerAddress")
                winner = when(winnerAddress) {
                    playerAddress.address -> GameResult.Win
                    Address.DEFAULT.toString() -> GameResult.Draw
                    else -> GameResult.Lose
                }
                betAmount = bet
            }
        }

    }

    private suspend fun whosTurnDefine(){
        Log.d("Tictacviewmodel","Player Address: ${playerAddress.address}")
        val currentPlayer = rep.getCurrentPlayer()
        when (currentPlayer){
            is Resource.Success ->{
                Log.d("Tictacviewmodel","Current Player Address: ${currentPlayer.data?.address}")
                whosTurn = (currentPlayer.data?.address == playerAddress.address)
            }
            is Resource.Error ->{
                errorChannel.send(currentPlayer.message?:UiText.StringResource(R.string.unknown_error_message))
                error = true
            }
        }
    }

    fun set(position:BigInteger){
        loading = true
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
            loading = false
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