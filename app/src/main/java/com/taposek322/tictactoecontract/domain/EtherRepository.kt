package com.taposek322.tictactoecontract.domain

import com.taposek322.tictactoecontract.generated.EmployeeSalary
import java.math.BigDecimal
import java.math.BigInteger

interface EtherRepository {

    suspend fun createContract()

    suspend fun connectToContract(contractAddress:String)

    suspend fun getEmployeeNum():BigInteger

    suspend fun getEmploee(): EmployeeSalary.EmployeeRecord

    suspend fun registerEmployee(name:String, age:BigInteger , amount:BigInteger,address:String)

    suspend fun transferEth(ethAmount:BigDecimal)

    suspend fun getContractBalance():BigInteger

}