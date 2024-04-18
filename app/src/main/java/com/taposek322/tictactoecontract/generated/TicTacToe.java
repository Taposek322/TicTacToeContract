package com.taposek322.tictactoecontract.generated;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
public class TicTacToe extends Contract {
    public static final String BINARY = "6080604052348015600f57600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550611b548061005f6000396000f3fe60806040526004361061009c5760003560e01c80635e123ce4116100645780635e123ce41461016c578063650271d2146101975780636f9fb98a146101c057806376cdb03b146101eb578063d30895e414610216578063ec4119c9146102415761009c565b80632389a290146100a157806328ed6e3f146100bd5780634404a438146100fa578063474d0b5a1461012557806359a5f12d14610141575b600080fd5b6100bb60048036038101906100b6919061143a565b61026c565b005b3480156100c957600080fd5b506100e460048036038101906100df919061149d565b610505565b6040516100f191906114e6565b60405180910390f35b34801561010657600080fd5b5061010f61052f565b60405161011c9190611510565b60405180910390f35b61013f600480360381019061013a919061143a565b610555565b005b34801561014d57600080fd5b50610156610892565b6040516101639190611510565b60405180910390f35b34801561017857600080fd5b506101816108b8565b60405161018e9190611546565b60405180910390f35b3480156101a357600080fd5b506101be60048036038101906101b9919061158d565b6108cb565b005b3480156101cc57600080fd5b506101d5610cfd565b6040516101e291906115c9565b60405180910390f35b3480156101f757600080fd5b50610200610d05565b60405161020d91906115c9565b60405180910390f35b34801561022257600080fd5b5061022b610d0b565b6040516102389190611510565b60405180910390f35b34801561024d57600080fd5b50610256610d2f565b6040516102639190611510565b60405180910390f35b600260149054906101000a900460ff16156102bc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102b390611641565b60405180910390fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461034c576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610343906116ad565b60405180910390fd5b6000341161038f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161038690611719565b60405180910390fd5b60035434146103d3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103ca90611719565b60405180910390fd5b3073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614610441576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161043890611785565b60405180910390fd5b33600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001600260146101000a81548160ff021916908315150217905550600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167fca52ae9e745ec5bf5a48cf30b628662bf2ae7d128c315f34419cdb64d784117c60405160405180910390a250565b6004816009811061051557600080fd5b60209182820401919006915054906101000a900460ff1681565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600260149054906101000a900460ff16156105a5576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161059c90611641565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415801561062e575060008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614155b61066d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610664906117f1565b60405180910390fd5b600034116106b0576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016106a790611719565b60405180910390fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555034600360008282546107039190611840565b92505081905550600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167fd152bf1ab39ec18e27d3dcb4f271007b0107191d3e8bed48c19ca8c9c1309e26346040516107a991906115c9565b60405180910390a360006002426107c091906118a3565b0361082b5760008054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555061088f565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600260149054906101000a900460ff1681565b600260149054906101000a900460ff1661091a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161091190611920565b60405180910390fd5b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146109aa576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109a19061198c565b60405180910390fd5b60098160ff16106109f0576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109e7906119f8565b60405180910390fd5b600060048260ff1660098110610a0957610a08611a18565b5b602091828204019190069054906101000a900460ff1660ff1614610a62576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a5990611a93565b60405180910390fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1603610af357600160048260ff1660098110610ace57610acd611a18565b5b602091828204019190066101000a81548160ff021916908360ff160217905550610b83565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1603610b8257600260048260ff1660098110610b6157610b60611a18565b5b602091828204019190066101000a81548160ff021916908360ff1602179055505b5b3373ffffffffffffffffffffffffffffffffffffffff167fa0b977d49f53322b6132c432cda188cfeb15c19f14082685ceabe0e44a99c54382604051610bc991906114e6565b60405180910390a2610bd9610d55565b80610be85750610be761109f565b5b15610bfa57610bf5611110565b610cfa565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614610c955760008054906101000a900473ffffffffffffffffffffffffffffffffffffffff16610cb9565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff165b600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b600047905090565b60035481565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000806040518061010001604052806040518060600160405280600060ff168152602001600160ff168152602001600260ff1681525081526020016040518060600160405280600360ff168152602001600460ff168152602001600560ff1681525081526020016040518060600160405280600660ff168152602001600760ff168152602001600860ff1681525081526020016040518060600160405280600060ff168152602001600360ff168152602001600660ff1681525081526020016040518060600160405280600160ff168152602001600460ff168152602001600760ff1681525081526020016040518060600160405280600260ff168152602001600560ff168152602001600860ff1681525081526020016040518060600160405280600060ff168152602001600460ff168152602001600860ff1681525081526020016040518060600160405280600260ff168152602001600460ff168152602001600660ff16815250815250905060005b60088160ff161015611095576000828260ff1660088110610eeb57610eea611a18565b5b602002015190506000600482600060038110610f0a57610f09611a18565b5b602002015160ff1660098110610f2357610f22611a18565b5b602091828204019190069054906101000a900460ff1660ff1614158015610fd75750600481600160038110610f5b57610f5a611a18565b5b602002015160ff1660098110610f7457610f73611a18565b5b602091828204019190069054906101000a900460ff1660ff16600482600060038110610fa357610fa2611a18565b5b602002015160ff1660098110610fbc57610fbb611a18565b5b602091828204019190069054906101000a900460ff1660ff16145b80156110705750600481600260038110610ff457610ff3611a18565b5b602002015160ff166009811061100d5761100c611a18565b5b602091828204019190069054906101000a900460ff1660ff1660048260006003811061103c5761103b611a18565b5b602002015160ff166009811061105557611054611a18565b5b602091828204019190069054906101000a900460ff1660ff16145b15611081576001935050505061109c565b50808061108d90611ab3565b915050610ec7565b5060009150505b90565b600080600090505b60098160ff16101561110757600060048260ff16600981106110cc576110cb611a18565b5b602091828204019190069054906101000a900460ff1660ff16036110f457600091505061110d565b80806110ff90611ab3565b9150506110a7565b50600190505b90565b611118610d55565b1561128c5760008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146111bb5760008054906101000a900473ffffffffffffffffffffffffffffffffffffffff166111df565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff165b90508073ffffffffffffffffffffffffffffffffffffffff167f27223f8d1d659564536abdf661d810b8a16ca4f6c69034f2a73b74b0853d982960035460405161122991906115c9565b60405180910390a28073ffffffffffffffffffffffffffffffffffffffff166108fc600260035461125a9190611adc565b9081150290604051600060405180830381858888f19350505050158015611285573d6000803e3d6000fd5b50506113b2565b600073ffffffffffffffffffffffffffffffffffffffff167f27223f8d1d659564536abdf661d810b8a16ca4f6c69034f2a73b74b0853d98296003546040516112d591906115c9565b60405180910390a260008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc6003549081150290604051600060405180830381858888f19350505050158015611345573d6000803e3d6000fd5b50600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc6003549081150290604051600060405180830381858888f193505050501580156113b0573d6000803e3d6000fd5b505b6000600260146101000a81548160ff0219169083151502179055506000600381905550565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000611407826113dc565b9050919050565b611417816113fc565b811461142257600080fd5b50565b6000813590506114348161140e565b92915050565b6000602082840312156114505761144f6113d7565b5b600061145e84828501611425565b91505092915050565b6000819050919050565b61147a81611467565b811461148557600080fd5b50565b60008135905061149781611471565b92915050565b6000602082840312156114b3576114b26113d7565b5b60006114c184828501611488565b91505092915050565b600060ff82169050919050565b6114e0816114ca565b82525050565b60006020820190506114fb60008301846114d7565b92915050565b61150a816113fc565b82525050565b60006020820190506115256000830184611501565b92915050565b60008115159050919050565b6115408161152b565b82525050565b600060208201905061155b6000830184611537565b92915050565b61156a816114ca565b811461157557600080fd5b50565b60008135905061158781611561565b92915050565b6000602082840312156115a3576115a26113d7565b5b60006115b184828501611578565b91505092915050565b6115c381611467565b82525050565b60006020820190506115de60008301846115ba565b92915050565b600082825260208201905092915050565b7f47616d6520616c72656164792073746172746564000000000000000000000000600082015250565b600061162b6014836115e4565b9150611636826115f5565b602082019050919050565b6000602082019050818103600083015261165a8161161e565b9050919050565b7f596f7520617265206e6f7420696e766974656420746f20746869732067616d65600082015250565b60006116976020836115e4565b91506116a282611661565b602082019050919050565b600060208201905081810360008301526116c68161168a565b9050919050565b7f496e76616c69642062657420616d6f756e740000000000000000000000000000600082015250565b60006117036012836115e4565b915061170e826116cd565b602082019050919050565b60006020820190508181036000830152611732816116f6565b9050919050565b7f496e76616c696420636f6e747261637420616464726573730000000000000000600082015250565b600061176f6018836115e4565b915061177a82611739565b602082019050919050565b6000602082019050818103600083015261179e81611762565b9050919050565b7f496e76616c696420706c61796572206164647265737300000000000000000000600082015250565b60006117db6016836115e4565b91506117e6826117a5565b602082019050919050565b6000602082019050818103600083015261180a816117ce565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600061184b82611467565b915061185683611467565b925082820190508082111561186e5761186d611811565b5b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b60006118ae82611467565b91506118b983611467565b9250826118c9576118c8611874565b5b828206905092915050565b7f47616d65206861736e2774207374617274656420796574000000000000000000600082015250565b600061190a6017836115e4565b9150611915826118d4565b602082019050919050565b60006020820190508181036000830152611939816118fd565b9050919050565b7f49742773206e6f7420796f7572207475726e0000000000000000000000000000600082015250565b60006119766012836115e4565b915061198182611940565b602082019050919050565b600060208201905081810360008301526119a581611969565b9050919050565b7f496e76616c696420706f736974696f6e00000000000000000000000000000000600082015250565b60006119e26010836115e4565b91506119ed826119ac565b602082019050919050565b60006020820190508181036000830152611a11816119d5565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f506f736974696f6e20616c7265616479206f6363757069656400000000000000600082015250565b6000611a7d6019836115e4565b9150611a8882611a47565b602082019050919050565b60006020820190508181036000830152611aac81611a70565b9050919050565b6000611abe826114ca565b915060ff8203611ad157611ad0611811565b5b600182019050919050565b6000611ae782611467565b9150611af283611467565b9250828202611b0081611467565b91508282048414831517611b1757611b16611811565b5b509291505056fea2646970667358221220b0a0076adfece08c3a79b7b0df47f5eddf15d14f67e639245886b0eb12d4ba4064736f6c63430008190033";

    private static String librariesLinkedBinary;

    public static final String FUNC_BANK = "bank";

    public static final String FUNC_BOARD = "board";

    public static final String FUNC_CREATEGAME = "createGame";

    public static final String FUNC_CURRENTPLAYER = "currentPlayer";

    public static final String FUNC_EXPECTEDPLAYER2 = "expectedPlayer2";

    public static final String FUNC_GAMESTARTED = "gameStarted";

    public static final String FUNC_GETCONTRACTBALANCE = "getContractBalance";

    public static final String FUNC_JOINGAME = "joinGame";

    public static final String FUNC_MAKEMOVE = "makeMove";

    public static final String FUNC_PLAYER1 = "player1";

    public static final String FUNC_PLAYER2 = "player2";

    public static final Event GAMECREATED_EVENT = new Event("GameCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event GAMEFINISHED_EVENT = new Event("GameFinished", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event MOVEMADE_EVENT = new Event("MoveMade", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint8>() {}));
    ;

    public static final Event PLAYER2JOINED_EVENT = new Event("Player2Joined", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected TicTacToe(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TicTacToe(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TicTacToe(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TicTacToe(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    /*
    public static List<GameCreatedEventResponse> getGameCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(GAMECREATED_EVENT, transactionReceipt);
        ArrayList<GameCreatedEventResponse> responses = new ArrayList<GameCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            GameCreatedEventResponse typedResponse = new GameCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.player1 = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.expectedPlayer2 = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.betAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }*/

    public static GameCreatedEventResponse getGameCreatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(GAMECREATED_EVENT, log);
        GameCreatedEventResponse typedResponse = new GameCreatedEventResponse();
        typedResponse.log = log;
        typedResponse.player1 = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.expectedPlayer2 = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.betAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<GameCreatedEventResponse> gameCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getGameCreatedEventFromLog(log));
    }

    public Flowable<GameCreatedEventResponse> gameCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(GAMECREATED_EVENT));
        return gameCreatedEventFlowable(filter);
    }

    /*public static List<GameFinishedEventResponse> getGameFinishedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(GAMEFINISHED_EVENT, transactionReceipt);
        ArrayList<GameFinishedEventResponse> responses = new ArrayList<GameFinishedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            GameFinishedEventResponse typedResponse = new GameFinishedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.winner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amountWon = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }*/

    public static GameFinishedEventResponse getGameFinishedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(GAMEFINISHED_EVENT, log);
        GameFinishedEventResponse typedResponse = new GameFinishedEventResponse();
        typedResponse.log = log;
        typedResponse.winner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.amountWon = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<GameFinishedEventResponse> gameFinishedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getGameFinishedEventFromLog(log));
    }

    public Flowable<GameFinishedEventResponse> gameFinishedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(GAMEFINISHED_EVENT));
        return gameFinishedEventFlowable(filter);
    }

    /*
    public static List<MoveMadeEventResponse> getMoveMadeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MOVEMADE_EVENT, transactionReceipt);
        ArrayList<MoveMadeEventResponse> responses = new ArrayList<MoveMadeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MoveMadeEventResponse typedResponse = new MoveMadeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.player = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.position = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }*/

    public static MoveMadeEventResponse getMoveMadeEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(MOVEMADE_EVENT, log);
        MoveMadeEventResponse typedResponse = new MoveMadeEventResponse();
        typedResponse.log = log;
        typedResponse.player = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.position = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<MoveMadeEventResponse> moveMadeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getMoveMadeEventFromLog(log));
    }

    public Flowable<MoveMadeEventResponse> moveMadeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MOVEMADE_EVENT));
        return moveMadeEventFlowable(filter);
    }

    /*
    public static List<Player2JoinedEventResponse> getPlayer2JoinedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PLAYER2JOINED_EVENT, transactionReceipt);
        ArrayList<Player2JoinedEventResponse> responses = new ArrayList<Player2JoinedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            Player2JoinedEventResponse typedResponse = new Player2JoinedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.player2 = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }*/

    public static Player2JoinedEventResponse getPlayer2JoinedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(PLAYER2JOINED_EVENT, log);
        Player2JoinedEventResponse typedResponse = new Player2JoinedEventResponse();
        typedResponse.log = log;
        typedResponse.player2 = (String) eventValues.getIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<Player2JoinedEventResponse> player2JoinedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getPlayer2JoinedEventFromLog(log));
    }

    public Flowable<Player2JoinedEventResponse> player2JoinedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PLAYER2JOINED_EVENT));
        return player2JoinedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> bank() {
        final Function function = new Function(FUNC_BANK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> board(BigInteger param0) {
        final Function function = new Function(FUNC_BOARD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createGame(String _expectedPlayer2, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_CREATEGAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _expectedPlayer2)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> currentPlayer() {
        final Function function = new Function(FUNC_CURRENTPLAYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> expectedPlayer2() {
        final Function function = new Function(FUNC_EXPECTEDPLAYER2, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> gameStarted() {
        final Function function = new Function(FUNC_GAMESTARTED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> getContractBalance() {
        final Function function = new Function(FUNC_GETCONTRACTBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> joinGame(String _contractAddress, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_JOINGAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _contractAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> makeMove(BigInteger position) {
        final Function function = new Function(
                FUNC_MAKEMOVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(position)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> player1() {
        final Function function = new Function(FUNC_PLAYER1, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> player2() {
        final Function function = new Function(FUNC_PLAYER2, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static TicTacToe load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TicTacToe(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TicTacToe load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TicTacToe(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TicTacToe load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TicTacToe(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TicTacToe load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TicTacToe(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TicTacToe> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TicTacToe.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<TicTacToe> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TicTacToe.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<TicTacToe> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TicTacToe.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<TicTacToe> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TicTacToe.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

   /* public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }*/

    public static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class GameCreatedEventResponse extends BaseEventResponse {
        public String player1;

        public String expectedPlayer2;

        public BigInteger betAmount;
    }

    public static class GameFinishedEventResponse extends BaseEventResponse {
        public String winner;

        public BigInteger amountWon;
    }

    public static class MoveMadeEventResponse extends BaseEventResponse {
        public String player;

        public BigInteger position;
    }

    public static class Player2JoinedEventResponse extends BaseEventResponse {
        public String player2;
    }
}