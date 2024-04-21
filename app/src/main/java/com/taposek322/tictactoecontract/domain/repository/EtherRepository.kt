package com.taposek322.tictactoecontract.domain.repository

import com.taposek322.tictactoecontract.domain.gamefield.GameFieldEvent
import com.taposek322.tictactoecontract.domain.gamefield.Player
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.generated.TicTacToe
import com.taposek322.tictactoecontract.presentation.util.UiText
import io.reactivex.Flowable
import org.web3j.protocol.core.DefaultBlockParameter
import java.math.BigDecimal
import java.math.BigInteger

interface EtherRepository {

    suspend fun connectToWeb(connectionString:String,chainId:Long,privateKey:String): Resource<UiText>

    fun getContractAddress():String
    suspend fun createContract():Resource<UiText>

    suspend fun connectToContract(contractAddress:String):Resource<UiText>

    //suspend fun transferEth(ethAmount:BigDecimal):Resource<UiText>

    suspend fun getContractBalance():Resource<BigInteger>

    suspend fun createGame(expectedPlayer2:String, ethAmount: BigDecimal):Resource<UiText>

    suspend fun joinGame(contractAddress: String,ethAmount: BigDecimal):Resource<UiText>

    suspend fun makeMove(position:BigInteger): Resource<UiText>

    suspend fun getCurrentPlayer(): Resource<Player>

    fun subscribeToGameCreatedEvents(): Flowable<TicTacToe.GameCreatedEventResponse>

    fun subscribeToPlayer2JoinedEvents(callback: () -> Unit)

    fun subscribeToMoveMadeEvents(callback:(GameFieldEvent)->Unit)

    fun subscribeToGameFinishedEvents(callback: (String,Long) -> Unit)

    fun getPlayerAddress():Player
}