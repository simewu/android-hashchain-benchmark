package _TMSI_Contract_Wrapper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint32;
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
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class TMSI_Contract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506102c5806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806394ddd30614610051578063b3e9183414610066578063d20f7f261461008e578063da91254c14610104575b600080fd5b61006461005f3660046101ec565b610112565b005b610079610074366004610241565b610172565b60405190151581526020015b60405180910390f35b6100ef61009c366004610263565b604080516001600160a01b0383166020820152908101839052600090819060600160408051808303601f19018152918152815160209283012060009081529182905290205463ffffffff16949350505050565b60405163ffffffff9091168152602001610085565b604051338152602001610085565b61011b33610172565b1561016e576040805133602082015290810183905260009060600160408051808303601f1901815291815281516020928301206000908152918290529020805463ffffffff191663ffffffff8416179055505b5050565b6000735b38da6a701c568545dcfcb03fcb875f56beddc46001600160a01b03831614156101a157506001919050565b73235d39cda65c223611ea2a914fd686307ff389a46001600160a01b03831614156101ce57506001919050565b6001600160a01b0382166101e457506001919050565b506000919050565b600080604083850312156101ff57600080fd5b82359150602083013563ffffffff8116811461021a57600080fd5b809150509250929050565b80356001600160a01b038116811461023c57600080fd5b919050565b60006020828403121561025357600080fd5b61025c82610225565b9392505050565b6000806040838503121561027657600080fd5b8235915061028660208401610225565b9050925092905056fea2646970667358221220562faea89954aefcccf99f716e4230d7b08c0703736ef6f9b5f671e4f585bc7764736f6c634300080c0033";

    public static final String FUNC_HASWRITEPRIVILEGE = "hasWritePrivilege";

    public static final String FUNC_RETRIEVE = "retrieve";

    public static final String FUNC_STORE = "store";

    public static final String FUNC_WHOAMI = "whoAmI";

    @Deprecated
    protected TMSI_Contract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TMSI_Contract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TMSI_Contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TMSI_Contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> hasWritePrivilege(String user) {
        final Function function = new Function(FUNC_HASWRITEPRIVILEGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> retrieve(BigInteger index, String user) {
        final Function function = new Function(FUNC_RETRIEVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.Address(160, user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> store(BigInteger index, BigInteger tsmi) {
        final Function function = new Function(
                FUNC_STORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.generated.Uint32(tsmi)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> whoAmI() {
        final Function function = new Function(FUNC_WHOAMI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static TMSI_Contract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TMSI_Contract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TMSI_Contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TMSI_Contract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TMSI_Contract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TMSI_Contract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TMSI_Contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TMSI_Contract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TMSI_Contract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TMSI_Contract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TMSI_Contract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TMSI_Contract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TMSI_Contract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TMSI_Contract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TMSI_Contract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TMSI_Contract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
