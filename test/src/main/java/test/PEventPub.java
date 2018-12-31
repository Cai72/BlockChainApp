package test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class PEventPub extends Contract {
    private static final String BINARY = "\"object\": \"608060405234801561001057600080fd5b506109e8806100206000396000f3fe608060405234801561001057600080fd5b506004361061009a576000357c0100000000000000000000000000000000000000000000000000000000900480639e7b8d61116100785780639e7b8d61146101ba578063a2fb1175146101fe578063d56b28891461026c578063d5c0c8f6146102cb5761009a565b80633493da9f1461009f578063809597211461011857806391ac1d8314610162575b600080fd5b6100cb600480360360208110156100b557600080fd5b810190808035906020019092919050505061030d565b604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001821515151581526020019250505060405180910390f35b610120610369565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101a46004803603602081101561017857600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061038e565b6040518082815260200191505060405180910390f35b6101fc600480360360208110156101d057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506103a6565b005b61022a6004803603602081101561021457600080fd5b8101908080359060200190929190505050610568565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6102746105a6565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156102b757808201518184015260208101905061029c565b505050509050019250505060405180910390f35b61030b600480360360608110156102e157600080fd5b8101908080359060200190929190803590602001909291908035906020019092919050505061094d565b005b60058181548110151561031c57fe5b906000526020600020016000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060000160149054906101000a900460ff16905082565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60066020528060005260406000206000915090505481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614801561044257506001600660008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205414155b80156104545750600354600580549050105b151561045f57600080fd5b6001600660008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550600560408051908101604052808373ffffffffffffffffffffffffffffffffffffffff1681526020016000151581525090806001815401808255809150509060018203906000526020600020016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160000160146101000a81548160ff02191690831515021790555050505050565b60018181548110151561057757fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60606000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561060357600080fd5b6000809050600080600454141561073d5760008090505b6005805490508110156107375760058054905060405180807f6e6f772c6d73672e73656e6465722c72616e644e6f6e63650000000000000000815250601801905060405180910390206001900481151561067057fe5b0691506005805490506002540260648302101561072a57600160058281548110151561069857fe5b9060005260206000200160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505b808060010191505061061a565b506108bf565b60008090505b6004548112156108bd575b60058054905060405180807f6e6f772c206d73672e73656e6465722c2072616e644e6f6e6365000000000000815250601a01905060405180910390206001900481151561079757fe5b0691508280600101935050600115156005838154811015156107b557fe5b9060005260206000200160000160149054906101000a900460ff16151514151561074e5760016005838154811015156107ea57fe5b9060005260206000200160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600160058381548110151561088c57fe5b9060005260206000200160000160146101000a81548160ff0219169083151502179055508080600101915050610743565b505b600180548060200260200160405190810160405280929190818152602001828054801561094157602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116108f7575b50505050509250505090565b82600281905550336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600381905550600060035414156109b0576103e76003819055505b8060048190555050505056fea165627a7a72305820e2b20b41a635d84c45a9d1688fb91091dba6ee6a343ab0f6078b56529761fb250029\"\r\n";

    protected PEventPub(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PEventPub(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple2<String, Boolean>> paticipants(BigInteger param0) {
        final Function function = new Function("paticipants", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple2<String, Boolean>>(
                new Callable<Tuple2<String, Boolean>>() {
                    @Override
                    public Tuple2<String, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, Boolean>(
                                (String) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<String> poster() {
        final Function function = new Function("poster", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> InvolveSearch(String param0) {
        final Function function = new Function("InvolveSearch", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> giveRightToVote(String paticipant) {
        final Function function = new Function(
                "giveRightToVote", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(paticipant)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> winners(BigInteger param0) {
        final Function function = new Function("winners", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> finish() {
        final Function function = new Function(
                "finish", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> init(BigInteger p, BigInteger pLimit, BigInteger wLimit) {
        final Function function = new Function(
                "init", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(p), 
                new org.web3j.abi.datatypes.generated.Int256(pLimit), 
                new org.web3j.abi.datatypes.generated.Int256(wLimit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<PEventPub> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PEventPub.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<PEventPub> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PEventPub.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static PEventPub load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PEventPub(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static PEventPub load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PEventPub(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
