package com.taposek322.tictactoecontract.data.repository

import android.util.Log
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.generated.TicTacToe
import com.taposek322.tictactoecontract.presentation.util.UiText
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.protocol.core.methods.response.Web3ClientVersion
import org.web3j.protocol.http.HttpService
import org.web3j.tx.RawTransactionManager
import org.web3j.tx.TransactionManager
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.utils.Convert
import java.math.BigDecimal
import java.math.BigInteger
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