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
    public static final String BINARY = "6080604052348015600f57600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550611bc58061005f6000396000f3fe6080604052600436106100a75760003560e01c80635e123ce4116100645780635e123ce4146101a2578063650271d2146101cd5780636f9fb98a146101f657806376cdb03b14610221578063d30895e41461024c578063ec4119c914610277576100a7565b80632389a290146100ac57806328ed6e3f146100c85780634404a43814610105578063474d0b5a14610130578063476e61721461014c57806359a5f12d14610177575b600080fd5b6100c660048036038101906100c19190611447565b6102a2565b005b3480156100d457600080fd5b506100ef60048036038101906100ea91906114aa565b61053b565b6040516100fc91906114f3565b60405180910390f35b34801561011157600080fd5b5061011a610565565b604051610127919061151d565b60405180910390f35b61014a60048036038101906101459190611447565b61058b565b005b34801561015857600080fd5b506101616108c8565b60405161016e919061151d565b60405180910390f35b34801561018357600080fd5b5061018c6108f2565b604051610199919061151d565b60405180910390f35b3480156101ae57600080fd5b506101b7610918565b6040516101c49190611553565b60405180910390f35b3480156101d957600080fd5b506101f460048036038101906101ef919061159a565b61092b565b005b34801561020257600080fd5b5061020b610d8b565b60405161021891906115d6565b60405180910390f35b34801561022d57600080fd5b50610236610d93565b60405161024391906115d6565b60405180910390f35b34801561025857600080fd5b50610261610d99565b60405161026e919061151d565b60405180910390f35b34801561028357600080fd5b5061028c610dbd565b604051610299919061151d565b60405180910390f35b600260149054906101000a900460ff16156102f2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102e99061164e565b60405180910390fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610382576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610379906116ba565b60405180910390fd5b600034116103c5576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103bc90611726565b60405180910390fd5b6003543414610409576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161040090611726565b60405180910390fd5b3073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614610477576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161046e90611792565b60405180910390fd5b33600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001600260146101000a81548160ff021916908315150217905550600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167fca52ae9e745ec5bf5a48cf30b628662bf2ae7d128c315f34419cdb64d784117c60405160405180910390a250565b6004816009811061054b57600080fd5b60209182820401919006915054906101000a900460ff1681565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600260149054906101000a900460ff16156105db576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105d29061164e565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614158015610664575060008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614155b6106a3576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161069a906117fe565b60405180910390fd5b600034116106e6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016106dd90611726565b60405180910390fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055503460036000828254610739919061184d565b92505081905550600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167fd152bf1ab39ec18e27d3dcb4f271007b0107191d3e8bed48c19ca8c9c1309e26346040516107df91906115d6565b60405180910390a360006002426107f691906118b0565b036108615760008054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506108c5565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600260149054906101000a900460ff1681565b600260149054906101000a900460ff1661097a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109719061192d565b60405180910390fd5b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610a0a576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a0190611999565b60405180910390fd5b60098160ff1610610a50576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a4790611a05565b60405180910390fd5b600060048260ff1660098110610a6957610a68611a25565b5b602091828204019190069054906101000a900460ff1660ff1614610ac2576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610ab990611aa0565b60405180910390fd5b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1603610b5357600160048260ff1660098110610b2e57610b2d611a25565b5b602091828204019190066101000a81548160ff021916908360ff160217905550610be3565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1603610be257600260048260ff1660098110610bc157610bc0611a25565b5b602091828204019190066101000a81548160ff021916908360ff1602179055505b5b3373ffffffffffffffffffffffffffffffffffffffff167f0f8a6121c5adbaa2f4fbab7f7bd4e2d59392eee510151f145aa0ad300c97952a8260048460ff1660098110610c3357610c32611a25565b5b602091828204019190069054906101000a900460ff16604051610c57929190611afb565b60405180910390a2610c67610de3565b80610c765750610c7561112d565b5b15610c8857610c8361119e565b610d88565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614610d235760008054906101000a900473ffffffffffffffffffffffffffffffffffffffff16610d47565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff165b600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b600047905090565b60035481565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000806040518061010001604052806040518060600160405280600060ff168152602001600160ff168152602001600260ff1681525081526020016040518060600160405280600360ff168152602001600460ff168152602001600560ff1681525081526020016040518060600160405280600660ff168152602001600760ff168152602001600860ff1681525081526020016040518060600160405280600060ff168152602001600360ff168152602001600660ff1681525081526020016040518060600160405280600160ff168152602001600460ff168152602001600760ff1681525081526020016040518060600160405280600260ff168152602001600560ff168152602001600860ff1681525081526020016040518060600160405280600060ff168152602001600460ff168152602001600860ff1681525081526020016040518060600160405280600260ff168152602001600460ff168152602001600660ff16815250815250905060005b60088160ff161015611123576000828260ff1660088110610f7957610f78611a25565b5b602002015190506000600482600060038110610f9857610f97611a25565b5b602002015160ff1660098110610fb157610fb0611a25565b5b602091828204019190069054906101000a900460ff1660ff16141580156110655750600481600160038110610fe957610fe8611a25565b5b602002015160ff166009811061100257611001611a25565b5b602091828204019190069054906101000a900460ff1660ff1660048260006003811061103157611030611a25565b5b602002015160ff166009811061104a57611049611a25565b5b602091828204019190069054906101000a900460ff1660ff16145b80156110fe575060048160026003811061108257611081611a25565b5b602002015160ff166009811061109b5761109a611a25565b5b602091828204019190069054906101000a900460ff1660ff166004826000600381106110ca576110c9611a25565b5b602002015160ff16600981106110e3576110e2611a25565b5b602091828204019190069054906101000a900460ff1660ff16145b1561110f576001935050505061112a565b50808061111b90611b24565b915050610f55565b5060009150505b90565b600080600090505b60098160ff16101561119557600060048260ff166009811061115a57611159611a25565b5b602091828204019190069054906101000a900460ff1660ff160361118257600091505061119b565b808061118d90611b24565b915050611135565b50600190505b90565b6111a6610de3565b1561129957600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f27223f8d1d659564536abdf661d810b8a16ca4f6c69034f2a73b74b0853d982960035460405161121591906115d6565b60405180910390a2600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc60026003546112689190611b4d565b9081150290604051600060405180830381858888f19350505050158015611293573d6000803e3d6000fd5b506113bf565b600073ffffffffffffffffffffffffffffffffffffffff167f27223f8d1d659564536abdf661d810b8a16ca4f6c69034f2a73b74b0853d98296003546040516112e291906115d6565b60405180910390a260008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc6003549081150290604051600060405180830381858888f19350505050158015611352573d6000803e3d6000fd5b50600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc6003549081150290604051600060405180830381858888f193505050501580156113bd573d6000803e3d6000fd5b505b6000600260146101000a81548160ff0219169083151502179055506000600381905550565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000611414826113e9565b9050919050565b61142481611409565b811461142f57600080fd5b50565b6000813590506114418161141b565b92915050565b60006020828403121561145d5761145c6113e4565b5b600061146b84828501611432565b91505092915050565b6000819050919050565b61148781611474565b811461149257600080fd5b50565b6000813590506114a48161147e565b92915050565b6000602082840312156114c0576114bf6113e4565b5b60006114ce84828501611495565b91505092915050565b600060ff82169050919050565b6114ed816114d7565b82525050565b600060208201905061150860008301846114e4565b92915050565b61151781611409565b82525050565b6000602082019050611532600083018461150e565b92915050565b60008115159050919050565b61154d81611538565b82525050565b60006020820190506115686000830184611544565b92915050565b611577816114d7565b811461158257600080fd5b50565b6000813590506115948161156e565b92915050565b6000602082840312156115b0576115af6113e4565b5b60006115be84828501611585565b91505092915050565b6115d081611474565b82525050565b60006020820190506115eb60008301846115c7565b92915050565b600082825260208201905092915050565b7f47616d6520616c72656164792073746172746564000000000000000000000000600082015250565b60006116386014836115f1565b915061164382611602565b602082019050919050565b600060208201905081810360008301526116678161162b565b9050919050565b7f596f7520617265206e6f7420696e766974656420746f20746869732067616d65600082015250565b60006116a46020836115f1565b91506116af8261166e565b602082019050919050565b600060208201905081810360008301526116d381611697565b9050919050565b7f496e76616c69642062657420616d6f756e740000000000000000000000000000600082015250565b60006117106012836115f1565b915061171b826116da565b602082019050919050565b6000602082019050818103600083015261173f81611703565b9050919050565b7f496e76616c696420636f6e747261637420616464726573730000000000000000600082015250565b600061177c6018836115f1565b915061178782611746565b602082019050919050565b600060208201905081810360008301526117ab8161176f565b9050919050565b7f496e76616c696420706c61796572206164647265737300000000000000000000600082015250565b60006117e86016836115f1565b91506117f3826117b2565b602082019050919050565b60006020820190508181036000830152611817816117db565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600061185882611474565b915061186383611474565b925082820190508082111561187b5761187a61181e565b5b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b60006118bb82611474565b91506118c683611474565b9250826118d6576118d5611881565b5b828206905092915050565b7f47616d65206861736e2774207374617274656420796574000000000000000000600082015250565b60006119176017836115f1565b9150611922826118e1565b602082019050919050565b600060208201905081810360008301526119468161190a565b9050919050565b7f49742773206e6f7420796f7572207475726e0000000000000000000000000000600082015250565b60006119836012836115f1565b915061198e8261194d565b602082019050919050565b600060208201905081810360008301526119b281611976565b9050919050565b7f496e76616c696420706f736974696f6e00000000000000000000000000000000600082015250565b60006119ef6010836115f1565b91506119fa826119b9565b602082019050919050565b60006020820190508181036000830152611a1e816119e2565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f506f736974696f6e20616c7265616479206f6363757069656400000000000000600082015250565b6000611a8a6019836115f1565b9150611a9582611a54565b602082019050919050565b60006020820190508181036000830152611ab981611a7d565b9050919050565b6000819050919050565b6000611ae5611ae0611adb846114d7565b611ac0565b611474565b9050919050565b611af581611aca565b82525050565b6000604082019050611b106000830185611aec565b611b1d6020830184611aec565b9392505050565b6000611b2f826114d7565b915060ff8203611b4257611b4161181e565b5b600182019050919050565b6000611b5882611474565b9150611b6383611474565b9250828202611b7181611474565b91508282048414831517611b8857611b8761181e565b5b509291505056fea2646970667358221220900cc678fe8e3ce030be64fc9d9e5d85a473b6cdea5f42f8bfd78ad3a818449464736f6c63430008190033";

    private static String librariesLinkedBinary;

    public static final String FUNC_BANK = "bank";

    public static final String FUNC_BOARD = "board";

    public static final String FUNC_CREATEGAME = "createGame";

    public static final String FUNC_CURRENTPLAYER = "currentPlayer";

    public static final String FUNC_EXPECTEDPLAYER2 = "expectedPlayer2";

    public static final String FUNC_GAMESTARTED = "gameStarted";

    public static final String FUNC_GETCONTRACTBALANCE = "getContractBalance";

    public static final String FUNC_GETCURRENTPLAYER = "getCurrentPlayer";

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
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
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
    }

     */

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

    /*
    public static List<GameFinishedEventResponse> getGameFinishedEvents(TransactionReceipt transactionReceipt) {
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
    }

     */

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
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

     */

    public static MoveMadeEventResponse getMoveMadeEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(MOVEMADE_EVENT, log);
        MoveMadeEventResponse typedResponse = new MoveMadeEventResponse();
        typedResponse.log = log;
        typedResponse.player = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.position = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
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
    }

     */

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

    public RemoteFunctionCall<String> getCurrentPlayer() {
        final Function function = new Function(FUNC_GETCURRENTPLAYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    /*
    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

     */

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

        public BigInteger value;
    }

    public static class Player2JoinedEventResponse extends BaseEventResponse {
        public String player2;
    }
}
