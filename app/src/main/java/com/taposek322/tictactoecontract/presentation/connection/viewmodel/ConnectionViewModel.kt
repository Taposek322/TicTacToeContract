package com.taposek322.tictactoecontract.presentation.connection.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val tag = "ConnectionViewModel"

@HiltViewModel
class ConnectionViewModel @Inject constructor(
    private val rep: EtherRepository
):ViewModel() {

    var connectionString by mutableStateOf("http://194.59.40.99:8545/")
        private set

    var chainId by mutableStateOf("51515")
        private set
    var privateKey by mutableStateOf("")
        private set

    var loading by mutableStateOf(false)
        private set

    var success by mutableStateOf(false)
        private set

    var error by mutableStateOf(false)
        private set


    private var errorChannel = Channel<UiText>()
    val errorMessage = errorChannel.receiveAsFlow()

    fun changeConnectionString(value:String){
        connectionString = value
    }

    fun changeChainId(value:String){
        chainId = value
    }

    fun changePrivateKey(value:String){
        privateKey = value
    }


    fun connect(){
        success = false
        error = false
        loading = true
        CoroutineScope(Dispatchers.IO).launch{
            val result = rep.connectToWeb(
                connectionString = connectionString,
                chainId = chainId.toLong(),
                privateKey = privateKey
            )
            when(result){
                is Resource.Success->{
                    success = true
                }
                is Resource.Error->{
                    errorChannel.send(result.message?:UiText.StringResource(R.string.unknown_error_message))
                    error = true
                }
            }
            loading = false
        }
    }

    fun clear(){
        error = false
        success = false
        loading = false
    }
    /*
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
            //rep.registerEmployee(name,age,amount,address)
            Log.d(tag,"Employ was registered")
        }
    }

    fun getEmploy(){
        CoroutineScope(Dispatchers.IO).launch{
            //val employ = rep.getEmploee()
            //Log.d(tag,"EmployName:${employ.name}; EmployAge: ${employ.age}")
        }
    }

    fun getEmployNum(){
        CoroutineScope(Dispatchers.IO).launch{
            //val count = rep.getEmployeeNum()
            //Log.d(tag,"Employ count: $count")
        }
    }

    fun transferEth(amount: BigDecimal){
        CoroutineScope(Dispatchers.IO).launch{
            //rep.transferEth(amount)
        }
    }

    fun getContractBalance(){
        CoroutineScope(Dispatchers.IO).launch {
            val balance = rep.getContractBalance()
            Log.d(tag,"Balance:${balance}")
        }
    }

     */
}
/*
class ConnectionViewModelFactory(private val rep: EtherRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConnectionViewModel(rep) as T
    }
}*/