package com.taposek322.tictactoecontract.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.gamefield.ActionsValue
import com.taposek322.tictactoecontract.domain.gamefield.GameFieldEvent
import com.taposek322.tictactoecontract.domain.gamefield.Player
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.generated.TicTacToe
import com.taposek322.tictactoecontract.generated.TicTacToe.GAMECREATED_EVENT
import com.taposek322.tictactoecontract.generated.TicTacToe.GAMEFINISHED_EVENT
import com.taposek322.tictactoecontract.generated.TicTacToe.MOVEMADE_EVENT
import com.taposek322.tictactoecontract.generated.TicTacToe.PLAYER2JOINED_EVENT
import com.taposek322.tictactoecontract.presentation.util.UiText
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import org.web3j.abi.EventEncoder
import org.web3j.abi.datatypes.Event
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.request.EthFilter
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.protocol.core.methods.response.Web3ClientVersion
import org.web3j.protocol.http.HttpService
import org.web3j.tx.RawTransactionManager
import org.web3j.tx.TransactionManager
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.utils.Convert
import java.math.BigDecimal
import java.math.BigInteger
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val TAG="EtherRepositoryImpl"

class EtherRepositoryImpl @Inject constructor(): EtherRepository {

    private lateinit var contract: TicTacToe
    private lateinit var web3j: Web3j
    private lateinit var transactionManager: TransactionManager
    private lateinit var credential: Credentials

    override suspend fun connectToWeb(connectionString:String,chainId:Long,privateKey:String):Resource<UiText> {
        return try {
            web3j = Web3j.build(HttpService(connectionString))
            val clientVersion: Web3ClientVersion = web3j.web3ClientVersion().send()
            if (!clientVersion.hasError()) {
                credential = Credentials.create(privateKey)
                transactionManager = RawTransactionManager(web3j, credential, chainId)
                Resource.Success(data = null)
            } else {
                Resource.Error(message = UiText.StringResource(R.string.connection_to_web_error))
            }
        }
        catch (e: Exception)
        {
            Resource.Error(
                if(e.message != null)
                {
                    UiText.DynamicString(e.message!!)
                }
                else
                {
                    UiText.StringResource(resId = R.string.unknown_error_message)
                }
            )
        }
    }

    override fun getContractAddress():String{
        return contract.contractAddress
    }

    override suspend fun createContract():Resource<UiText> {
        return try {
            contract = TicTacToe.deploy(
                web3j,
                transactionManager,
                DefaultGasProvider()
            ).send()
            //Resource.Success(UiText.DynamicString(value = contract.contractAddress))
            Log.d(TAG,"Contract created. Address:${getContractAddress()}")
            Resource.Success(null)
        }
        catch (e: Exception)
        {
            Resource.Error(
                if(e.message != null)
                {
                    UiText.DynamicString(e.message!!)
                }
                else
                {
                    UiText.StringResource(resId = R.string.unknown_error_message)
                }
            )
        }
    }

    override suspend fun connectToContract(contractAddress: String):Resource<UiText> {
        return try {
            contract = TicTacToe.load(
                contractAddress,
                web3j,
                transactionManager,
                DefaultGasProvider()
            )
            Resource.Success(data = null)
        }
        catch (e: Exception)
        {
            Resource.Error(
                if(e.message != null)
                {
                    UiText.DynamicString(e.message!!)
                }
                else
                {
                    UiText.StringResource(resId = R.string.unknown_error_message)
                }
            )
        }
    }

    override suspend fun createGame(expectedPlayer2: String,ethAmount:BigDecimal): Resource<UiText> {
        return try {
            val weiCount = Convert.toWei(ethAmount, Convert.Unit.ETHER)
            val transactionReceipt: TransactionReceipt = contract.createGame(expectedPlayer2,weiCount.toBigInteger()).send()
            Log.d(TAG,"After transcationReceipt")
            if(transactionReceipt.isStatusOK){
                Log.d(TAG,"Game created")
                Resource.Success(data = null)
            }else{
                Resource.Error(message = UiText.DynamicString(value = transactionReceipt.status))
            }
        }catch (e:Exception){
            Resource.Error(
                if(e.message != null)
                {
                    UiText.DynamicString(e.message!!)
                }
                else
                {
                    UiText.StringResource(resId = R.string.unknown_error_message)
                }
            )
        }
    }

    override suspend fun joinGame(contractAddress: String,ethAmount: BigDecimal): Resource<UiText> {
        return try {
            val weiCount = Convert.toWei(ethAmount, Convert.Unit.ETHER)
            val transactionReceipt: TransactionReceipt = contract.joinGame(contractAddress,weiCount.toBigInteger()).send()
            if(transactionReceipt.isStatusOK)
            {
                Resource.Success(data = null)
            }
            else
            {
                Resource.Error(message = UiText.DynamicString(value = transactionReceipt.status))
            }
        }catch (e:Exception){
            Resource.Error(
                if(e.message != null)
                {
                    UiText.DynamicString(e.message!!)
                }
                else
                {
                    UiText.StringResource(resId = R.string.unknown_error_message)
                }
            )
        }
    }

    override suspend fun makeMove(position: BigInteger): Resource<UiText> {
        return try {
            val transactionReceipt: TransactionReceipt = contract.makeMove(position).send()
            if(transactionReceipt.isStatusOK)
            {
                Resource.Success(data = null)
            }
            else
            {
                Resource.Error(message = UiText.DynamicString(value = transactionReceipt.status))
            }
        }catch (e:Exception){
            Resource.Error(
                if(e.message != null)
                {
                    UiText.DynamicString(e.message!!)
                }
                else
                {
                    UiText.StringResource(resId = R.string.unknown_error_message)
                }
            )
        }
    }

    override suspend fun getContractBalance(): Resource<BigInteger> {
        return try {
            val balance = web3j.ethGetBalance(
                contract.contractAddress,
                DefaultBlockParameterName.LATEST
            ).send()
            Resource.Success(data = balance.balance)
        }
        catch (e:Exception)
        {
            Resource.Error(
                if(e.message != null)
                {
                    UiText.DynamicString(e.message!!)
                }
                else
                {
                    UiText.StringResource(resId = R.string.unknown_error_message)
                }
            )
        }
    }

    override suspend fun getCurrentPlayer(): Resource<Player> {
        return try {
            Log.d(TAG,"In getcurrent")
            //val currentPlayer = contract.currentPlayer.send()
            val currentPlayer = contract.currentPlayer().send()
            Log.d(TAG,"After send")
            Resource.Success(data = Player(currentPlayer))
        }catch (e:Exception){
            Resource.Error(
                if(e.message != null)
                {
                    UiText.DynamicString(e.message!!)
                }
                else
                {
                    UiText.StringResource(resId = R.string.unknown_error_message)
                }
            )
        }
    }

    override fun getPlayerAddress(): Player {
        return Player(credential.address)
    }

    override fun subscribeToGameCreatedEvents(): Flowable<TicTacToe.GameCreatedEventResponse> {
        return subscriptionToGameCreatedEvents(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST)
    }

    override fun subscribeToPlayer2JoinedEvents(callback: () -> Unit) {
        subscriptionToPlayer2JoinedEvents(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST,callback)
    }

    override fun subscribeToMoveMadeEvents(callback:(GameFieldEvent)->Unit) {
        subscriptionToMoveMadeEvents(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST,callback)
    }

    override fun subscribeToGameFinishedEvents(callback: (String,Long) -> Unit) {
        subscriptionToGameFinishedEvents(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST,callback)
    }


    @SuppressLint("CheckResult")
    private fun subscriptionToGameCreatedEvents(startBlock: DefaultBlockParameter, endBlock: DefaultBlockParameter):Flowable<TicTacToe.GameCreatedEventResponse> {
        val filter = EthFilter(startBlock, endBlock, contract.contractAddress)
        filter.addSingleTopic(EventEncoder.encode(GAMECREATED_EVENT))
        return Flowable.create({emitter  ->
            contract.gameCreatedEventFlowable(filter)
                .subscribe({ event ->
                    emitter.onNext(event)
                }, { error ->
                    error.printStackTrace()
                })
        },BackpressureStrategy.LATEST)
    }
    @SuppressLint("CheckResult")
    private fun subscriptionToPlayer2JoinedEvents(
        startBlock: DefaultBlockParameter,
        endBlock: DefaultBlockParameter,
        callback: () -> Unit
        )
    {
        val filter = EthFilter(startBlock, endBlock, contract.contractAddress)
        filter.addSingleTopic(EventEncoder.encode(PLAYER2JOINED_EVENT))
        contract.player2JoinedEventFlowable(filter)
            .subscribe({ event ->
                callback()
            }, { error ->
                error.printStackTrace()
            })
    }

    @SuppressLint("CheckResult")
    private fun subscriptionToMoveMadeEvents(
        startBlock: DefaultBlockParameter,
        endBlock: DefaultBlockParameter,
        callback:(GameFieldEvent)->Unit
    ) {
        val filter = EthFilter(startBlock, endBlock, contract.contractAddress)
        filter.addSingleTopic(EventEncoder.encode(MOVEMADE_EVENT))

        contract.moveMadeEventFlowable(filter)
            .subscribe({ event ->
                val act = when(event.value.toInt() ){
                    1->ActionsValue.XS
                    2->ActionsValue.OS
                    else ->null
                }

                callback(GameFieldEvent(
                    position = event.position.toInt(),
                    action = act
                ))
            }, { error ->
                error.printStackTrace()
            })
    }

    @SuppressLint("CheckResult")
    private fun subscriptionToGameFinishedEvents(
        startBlock: DefaultBlockParameter,
        endBlock: DefaultBlockParameter,
        callback: (String,Long) -> Unit) {
        val filter = EthFilter(startBlock, endBlock, contract.contractAddress)
        filter.addSingleTopic(EventEncoder.encode(GAMEFINISHED_EVENT))

        contract.gameFinishedEventFlowable(filter)
            .subscribe({ event ->
                callback(event.winner,event.amountWon.toLong())
            }, { error ->
                error.printStackTrace()
            })
    }

/*
@SuppressLint("CheckResult")
fun subscribeToGameCreatedEvents(startBlock: DefaultBlockParameter, endBlock: DefaultBlockParameter) {
   val filter = EthFilter(startBlock, endBlock, contract.contractAddress)
   filter.addSingleTopic(EventEncoder.encode(GAMECREATED_EVENT))

   val test = contract.gameCreatedEventFlowable(filter)
       .subscribe({ response ->
           val player1 = response.player1
           val expectedPlayer2 = response.expectedPlayer2
           val betAmount = response.betAmount
           Log.d(TAG, "Game created by $player1 with expected player $expectedPlayer2 and bet amount $betAmount")
       }, { error ->
           error.printStackTrace()
       })
}
@SuppressLint("CheckResult")
fun subscribeToPlayer2JoinedEvents(startBlock: DefaultBlockParameter, endBlock: DefaultBlockParameter) {
   val filter = EthFilter(startBlock, endBlock, contract.contractAddress)
   filter.addSingleTopic(EventEncoder.encode(PLAYER2JOINED_EVENT))

   contract.player2JoinedEventFlowable(filter)
       .subscribe({ response ->
           val player2 = response.player2
           Log.d(TAG, "Come $player2")
       }, { error ->
           error.printStackTrace()
       })
}

@SuppressLint("CheckResult")
fun subscribeToMoveMadeEvents(startBlock: DefaultBlockParameter, endBlock: DefaultBlockParameter) {
   val filter = EthFilter(startBlock, endBlock, contract.contractAddress)
   filter.addSingleTopic(EventEncoder.encode(MOVEMADE_EVENT))

   contract.moveMadeEventFlowable(filter)
       .subscribe({ response ->
           val player = response.player
           val position = response.position
       }, { error ->
           error.printStackTrace()
       })
}

@SuppressLint("CheckResult")
fun subscribeToGameFinishedEvents(startBlock: DefaultBlockParameter, endBlock: DefaultBlockParameter) {
   val filter = EthFilter(startBlock, endBlock, contract.contractAddress)
   filter.addSingleTopic(EventEncoder.encode(GAMEFINISHED_EVENT))

   contract.gameFinishedEventFlowable(filter)
       .subscribe({ response ->
           val winner = response.winner
           val amountWon = response.amountWon
       }, { error ->
           error.printStackTrace()
       })
}

*/

/*
override suspend fun transferEth(ethAmount: BigDecimal):Resource<UiText> {
   return try {
       val weiCount = Convert.toWei(ethAmount, Convert.Unit.ETHER)
       val transferReceipt = contract.deposit(weiCount.toBigInteger()).send()
       if(transferReceipt.is)
   }
   catch (e: Exception)
   {
       Resource.Error(
           if(e.message != null)
           {
               UiText.DynamicString(e.message!!)
           }
           else
           {
               UiText.StringResource(redId = R.string.unknown_error_message)
           }
       )
   }


   Log.d(TAG, "transferEth status:${transferReceipt.isStatusOK}")
}

*/

/*
override suspend fun getEmployeeNum(): BigInteger {
   val employeeNum: BigInteger = contract.employeeNum.send()
   return employeeNum
}

override suspend fun getEmploee(): EmployeeSalary.EmployeeRecord {
   val employee = contract.emploee.send()
   return employee
}

override suspend fun registerEmployee(name: String, age: BigInteger, amount: BigInteger, address: String) {
   val transactionReceipt: TransactionReceipt = contract.registerEmployee(
       name,
       age,
       amount,
       address
   ).send()

   Log.d(TAG, "TransactionReceipt status: ${transactionReceipt.status}")
}

*/





/*
companion object {
   private var INSTANCE: EtherRepositoryImpl? = null

   fun initialize(web3j: Web3j,
                  transactionManager: TransactionManager,
                  credential: Credentials,
                  chainId: Long
                  )
   {
       if (INSTANCE == null) {
           INSTANCE = EtherRepositoryImpl(
               web3j,
               transactionManager,
               credential,
               chainId
           )
       }
   }

   fun get(): EtherRepositoryImpl {
       return INSTANCE
           ?: throw IllegalStateException("EtherRepositoryImpl must be initialized")
   }
}
*/

}