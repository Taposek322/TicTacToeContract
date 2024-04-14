package com.taposek322.tictactoecontract.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taposek322.tictactoecontract.domain.EtherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.web3j.protocol.core.methods.response.Web3ClientVersion
import java.math.BigDecimal
import java.math.BigInteger
import java.security.PrivateKey


private const val tag = "ConnectionViewModel"

class ConnectionViewModel(
    private val rep:EtherRepository
):ViewModel() {

    fun connect(server:String,privateKey: PrivateKey){


    }
    fun createContract(){
        CoroutineScope(Dispatchers.IO).launch {
            rep.createContract()
        }
    }
    fun connectToContract(contractAddress:String){
        CoroutineScope(Dispatchers.IO).launch {
            rep.connectToContract(contractAddress)
        }
    }

    fun registerEmploy(name:String,age:BigInteger,amount:BigInteger,address:String){
        CoroutineScope(Dispatchers.IO).launch {
            rep.registerEmployee(name,age,amount,address)
            Log.d(tag,"Employ was registered")
        }
    }

    fun getEmploy(){
        CoroutineScope(Dispatchers.IO).launch{
            val employ = rep.getEmploee()
            Log.d(tag,"EmployName:${employ.name}; EmployAge: ${employ.age}")
        }
    }

    fun getEmployNum(){
        CoroutineScope(Dispatchers.IO).launch{
            val count = rep.getEmployeeNum()
            Log.d(tag,"Employ count: $count")
        }
    }

    fun transferEth(amount: BigDecimal){
        CoroutineScope(Dispatchers.IO).launch{
            rep.transferEth(amount)
        }
    }

    fun getContractBalance(){
        CoroutineScope(Dispatchers.IO).launch {
            val balance = rep.getContractBalance()
            Log.d(tag,"Balance:${balance}")
        }
    }
}

class ConnectionViewModelFactory(private val rep:EtherRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConnectionViewModel(rep) as T
    }
}