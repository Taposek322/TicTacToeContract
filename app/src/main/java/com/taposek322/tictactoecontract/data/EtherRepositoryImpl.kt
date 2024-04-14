package com.taposek322.tictactoecontract.data

import android.util.Log
import com.taposek322.tictactoecontract.domain.EtherRepository
import com.taposek322.tictactoecontract.generated.EmployeeSalary
import io.reactivex.Single
import org.web3j.crypto.Credentials
import org.web3j.crypto.RawTransaction
import org.web3j.crypto.TransactionEncoder
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.EthSendRawTransaction
import org.web3j.protocol.core.methods.response.EthSendTransaction
import org.web3j.protocol.core.methods.response.Transaction
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.tx.TransactionManager
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.utils.Convert
import org.web3j.utils.Numeric
import java.math.BigDecimal
import java.math.BigInteger


private const val TAG="EtherRepositoryImpl"

class EtherRepositoryImpl (
    private val web3j: Web3j,
    private val transactionManager: TransactionManager,
    private val credential: Credentials,
    private val chainId:Long
):EtherRepository {

    lateinit var contract:EmployeeSalary

    override suspend fun createContract() {
        contract = EmployeeSalary.deploy(
            web3j,
            transactionManager,
            DefaultGasProvider()).send()

        Log.d(TAG,"Contract address:${contract.contractAddress}")
    }

    override suspend fun connectToContract(contractAddress: String) {
        contract = EmployeeSalary.load(
            contractAddress,
            web3j,
            transactionManager,
            DefaultGasProvider()
        )
    }

    override suspend fun getEmployeeNum():BigInteger{
        val employeeNum:BigInteger = contract.employeeNum.send()
        return employeeNum
    }

    override suspend fun getEmploee():EmployeeSalary.EmployeeRecord {
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

        Log.d(TAG,"TransactionReceipt status: ${transactionReceipt.status}")
    }

    /*
    override suspend fun transferEth(ethAmount: BigDecimal) {
        val weiCount = Convert.toWei(ethAmount,Convert.Unit.ETHER)

        val transactionReceipt: TransactionReceipt = Transfer.sendFunds(
            web3j,
            credential,
            contract.contractAddress,
            weiCount,
            Convert.Unit.WEI
            //,
            //DefaultGasProvider.GAS_PRICE,
           // DefaultGasProvider.GAS_LIMIT
        ).send()

        val balance = web3j.ethGetBalance(contract.contractAddress, DefaultBlockParameterName.LATEST).send()

        Log.d(TAG,"Balance: ${balance.balance}")

    }*/


/*
    override suspend fun transferEth(ethAmount: BigDecimal) {

        val ethGetTransactionCount = web3j.ethGetTransactionCount(
            credential.address, DefaultBlockParameterName.LATEST
        ).send()

        val nonce = ethGetTransactionCount.transactionCount

        val weiCount = Convert.toWei(ethAmount,Convert.Unit.ETHER)

        val rawTransaction:RawTransaction = RawTransaction.createEtherTransaction(
            nonce,
            DefaultGasProvider.GAS_PRICE,
            DefaultGasProvider.GAS_LIMIT,
            contract.contractAddress,
            weiCount.toBigInteger(),
        )

        val signedMessage = TransactionEncoder.signMessage(rawTransaction,chainId,credential)
        val hexValues = Numeric.toHexString(signedMessage)

        val ethSendTransaction = web3j.ethSendRawTransaction(hexValues).send()

        if (ethSendTransaction.hasError()) {
            Log.d(TAG,"Error:${ethSendTransaction.error.message}");
        } else {
            Log.d(TAG,"Successful send")
        }
    }
 */

    override suspend fun transferEth(ethAmount: BigDecimal) {
        val weiCount = Convert.toWei(ethAmount,Convert.Unit.ETHER)
        val transferReceipt = contract.deposit(weiCount.toBigInteger()).send()

        Log.d(TAG,"transferEth status:${transferReceipt.isStatusOK}")
    }

    override suspend fun getContractBalance():BigInteger {
        val balance = web3j.ethGetBalance(contract.contractAddress,DefaultBlockParameterName.LATEST).send()
        return balance.balance
    }


    companion object {
        private var INSTANCE: EtherRepositoryImpl? = null

        fun initialize(web3j: Web3j,
                       transactionManager: TransactionManager,
                       credential: Credentials,
                       chainId: Long
                       )
        {
            if (INSTANCE == null) {
                INSTANCE = EtherRepositoryImpl(web3j,
                    transactionManager,
                    credential,
                    chainId)
            }
        }

        fun get(): EtherRepositoryImpl {
            return INSTANCE
                ?: throw IllegalStateException("EtherRepositoryImpl must be initialized")
        }
    }

}