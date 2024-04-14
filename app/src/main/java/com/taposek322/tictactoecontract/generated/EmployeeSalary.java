package com.taposek322.tictactoecontract.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.3.
 */
@SuppressWarnings("rawtypes")
public class EmployeeSalary extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506113da806100606000396000f3fe6080604052600436106100705760003560e01c80637ff4ad6c1161004e5780637ff4ad6c146100d35780639fd3666b146100fe578063d0e30db014610129578063e67047231461013357610070565b80633351b7ca1461007557806342f6487a1461009e5780637d1fcbfa146100a8575b600080fd5b34801561008157600080fd5b5061009c60048036038101906100979190610ac6565b61015e565b005b6100a661044f565b005b3480156100b457600080fd5b506100bd61062b565b6040516100ca9190610b74565b60405180910390f35b3480156100df57600080fd5b506100e8610633565b6040516100f59190610c87565b60405180910390f35b34801561010a57600080fd5b506101136107c2565b6040516101209190610b74565b60405180910390f35b6101316107cf565b005b34801561013f57600080fd5b5061014861082b565b6040516101559190610cea565b60405180910390f35b60648211156101a2576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161019990610d88565b60405180910390fd5b60006101ac610854565b905060008080600090505b60018054905081101561028c573373ffffffffffffffffffffffffffffffffffffffff16600182815481106101ef576101ee610da8565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff160361027f57600192506001818154811061024d5761024c610da8565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16915061028c565b80806001019150506101b7565b5081156102e457600260008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060030154836102e19190610e06565b92505b848360646102f29190610e06565b1015610333576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161032a90610eac565b60405180910390fd5b604051806080016040528088815260200187815260200185815260200186815250600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000190816103a891906110d8565b506020820151816001015560408201518160020190816103c891906110d8565b50606082015181600301559050506000151582151503610446576001339080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50505050505050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146104dd576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016104d49061121c565b60405180910390fd5b600047905060005b6001805490508110156106275760006064600260006001858154811061050e5761050d610da8565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003015484610582919061123c565b61058c91906112ad565b90506000600183815481106105a4576105a3610da8565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050158015610617573d6000803e3d6000fd5b50505080806001019150506104e5565b5050565b600047905090565b61063b61090e565b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060405180608001604052908160008201805461069590610efb565b80601f01602080910402602001604051908101604052809291908181526020018280546106c190610efb565b801561070e5780601f106106e35761010080835404028352916020019161070e565b820191906000526020600020905b8154815290600101906020018083116106f157829003601f168201915b505050505081526020016001820154815260200160028201805461073190610efb565b80601f016020809104026020016040519081016040528092919081815260200182805461075d90610efb565b80156107aa5780601f1061077f576101008083540402835291602001916107aa565b820191906000526020600020905b81548152906001019060200180831161078d57829003601f168201915b50505050508152602001600382015481525050905090565b6000600180549050905090565b3373ffffffffffffffffffffffffffffffffffffffff1631341115610829576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161082090611350565b60405180910390fd5b565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000806000905060005b60018054905081101561090657600260006001838154811061088357610882610da8565b5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060030154826108f79190611370565b9150808060010191505061085e565b508091505090565b6040518060800160405280606081526020016000815260200160608152602001600081525090565b6000604051905090565b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b61099d82610954565b810181811067ffffffffffffffff821117156109bc576109bb610965565b5b80604052505050565b60006109cf610936565b90506109db8282610994565b919050565b600067ffffffffffffffff8211156109fb576109fa610965565b5b610a0482610954565b9050602081019050919050565b82818337600083830152505050565b6000610a33610a2e846109e0565b6109c5565b905082815260208101848484011115610a4f57610a4e61094f565b5b610a5a848285610a11565b509392505050565b600082601f830112610a7757610a7661094a565b5b8135610a87848260208601610a20565b91505092915050565b6000819050919050565b610aa381610a90565b8114610aae57600080fd5b50565b600081359050610ac081610a9a565b92915050565b60008060008060808587031215610ae057610adf610940565b5b600085013567ffffffffffffffff811115610afe57610afd610945565b5b610b0a87828801610a62565b9450506020610b1b87828801610ab1565b9350506040610b2c87828801610ab1565b925050606085013567ffffffffffffffff811115610b4d57610b4c610945565b5b610b5987828801610a62565b91505092959194509250565b610b6e81610a90565b82525050565b6000602082019050610b896000830184610b65565b92915050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610bc9578082015181840152602081019050610bae565b60008484015250505050565b6000610be082610b8f565b610bea8185610b9a565b9350610bfa818560208601610bab565b610c0381610954565b840191505092915050565b610c1781610a90565b82525050565b60006080830160008301518482036000860152610c3a8282610bd5565b9150506020830151610c4f6020860182610c0e565b5060408301518482036040860152610c678282610bd5565b9150506060830151610c7c6060860182610c0e565b508091505092915050565b60006020820190508181036000830152610ca18184610c1d565b905092915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610cd482610ca9565b9050919050565b610ce481610cc9565b82525050565b6000602082019050610cff6000830184610cdb565b92915050565b600082825260208201905092915050565b7f4572726f722e20416d6f756e742063616e74206265206772656174657220746860008201527f616e203130300000000000000000000000000000000000000000000000000000602082015250565b6000610d72602683610d05565b9150610d7d82610d16565b604082019050919050565b60006020820190508181036000830152610da181610d65565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000610e1182610a90565b9150610e1c83610a90565b9250828203905081811115610e3457610e33610dd7565b5b92915050565b7f4572726f722e20546f74616c2070657263656e746167652063616e606220626560008201527f2067726561746572207468616e20313030000000000000000000000000000000602082015250565b6000610e96603183610d05565b9150610ea182610e3a565b604082019050919050565b60006020820190508181036000830152610ec581610e89565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680610f1357607f821691505b602082108103610f2657610f25610ecc565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b600060088302610f8e7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82610f51565b610f988683610f51565b95508019841693508086168417925050509392505050565b6000819050919050565b6000610fd5610fd0610fcb84610a90565b610fb0565b610a90565b9050919050565b6000819050919050565b610fef83610fba565b611003610ffb82610fdc565b848454610f5e565b825550505050565b600090565b61101861100b565b611023818484610fe6565b505050565b5b818110156110475761103c600082611010565b600181019050611029565b5050565b601f82111561108c5761105d81610f2c565b61106684610f41565b81016020851015611075578190505b61108961108185610f41565b830182611028565b50505b505050565b600082821c905092915050565b60006110af60001984600802611091565b1980831691505092915050565b60006110c8838361109e565b9150826002028217905092915050565b6110e182610b8f565b67ffffffffffffffff8111156110fa576110f9610965565b5b6111048254610efb565b61110f82828561104b565b600060209050601f8311600181146111425760008415611130578287015190505b61113a85826110bc565b8655506111a2565b601f19841661115086610f2c565b60005b8281101561117857848901518255600182019150602085019450602081019050611153565b868310156111955784890151611191601f89168261109e565b8355505b6001600288020188555050505b505050505050565b7f4572726f722e204f6e6c7920746865206f776e65722063616e2063616c6c207460008201527f68697320636f6e747261632066756e6374696f6e000000000000000000000000602082015250565b6000611206603483610d05565b9150611211826111aa565b604082019050919050565b60006020820190508181036000830152611235816111f9565b9050919050565b600061124782610a90565b915061125283610a90565b925082820261126081610a90565b9150828204841483151761127757611276610dd7565b5b5092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b60006112b882610a90565b91506112c383610a90565b9250826112d3576112d261127e565b5b828204905092915050565b7f4572726f722e20596f7520646f6e742068617665207468697320616d6f756e7460008201527f206f6e20796f75722062616c616e636500000000000000000000000000000000602082015250565b600061133a603083610d05565b9150611345826112de565b604082019050919050565b600060208201905081810360008301526113698161132d565b9050919050565b600061137b82610a90565b915061138683610a90565b925082820190508082111561139e5761139d610dd7565b5b9291505056fea2646970667358221220e461c78d21b56e38db518f41a5b1245205c2b1fd4355e6b713ee4f1f7143a78164736f6c63430008180033";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_GETEMPLOEE = "getEmploee";

    public static final String FUNC_GETEMPLOYEENUM = "getEmployeeNum";

    public static final String FUNC_GETOWNERADDR = "getOwnerAddr";

    public static final String FUNC_GETTOTALREWARD = "getTotalReward";

    public static final String FUNC_PAYMENT = "payment";

    public static final String FUNC_REGISTEREMPLOYEE = "registerEmployee";

    @Deprecated
    protected EmployeeSalary(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EmployeeSalary(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EmployeeSalary(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EmployeeSalary(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<EmployeeRecord> getEmploee() {
        final Function function = new Function(FUNC_GETEMPLOEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<EmployeeRecord>() {}));
        return executeRemoteCallSingleValueReturn(function, EmployeeRecord.class);
    }

    public RemoteFunctionCall<BigInteger> getEmployeeNum() {
        final Function function = new Function(FUNC_GETEMPLOYEENUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getOwnerAddr() {
        final Function function = new Function(FUNC_GETOWNERADDR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getTotalReward() {
        final Function function = new Function(FUNC_GETTOTALREWARD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> payment(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PAYMENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> registerEmployee(String _name, BigInteger _age, BigInteger _amount, String _addr) {
        final Function function = new Function(
                FUNC_REGISTEREMPLOYEE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_age), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.Utf8String(_addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static EmployeeSalary load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EmployeeSalary(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EmployeeSalary load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EmployeeSalary(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EmployeeSalary load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EmployeeSalary(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EmployeeSalary load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EmployeeSalary(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EmployeeSalary> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EmployeeSalary.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<EmployeeSalary> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EmployeeSalary.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<EmployeeSalary> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EmployeeSalary.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<EmployeeSalary> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EmployeeSalary.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    /*public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }*/

    public static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class EmployeeRecord extends DynamicStruct {
        public String name;

        public BigInteger age;

        public String addr;

        public BigInteger amount;

        public EmployeeRecord(String name, BigInteger age, String addr, BigInteger amount) {
            super(new org.web3j.abi.datatypes.Utf8String(name), 
                    new org.web3j.abi.datatypes.generated.Uint256(age), 
                    new org.web3j.abi.datatypes.Utf8String(addr), 
                    new org.web3j.abi.datatypes.generated.Uint256(amount));
            this.name = name;
            this.age = age;
            this.addr = addr;
            this.amount = amount;
        }

        public EmployeeRecord(Utf8String name, Uint256 age, Utf8String addr, Uint256 amount) {
            super(name, age, addr, amount);
            this.name = name.getValue();
            this.age = age.getValue();
            this.addr = addr.getValue();
            this.amount = amount.getValue();
        }
    }
}
