package TMSI_Contract_Wrapper;

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
public class Contract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610525806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806394ddd30614610051578063b3e918341461006d578063d20f7f261461009d578063da91254c146100cd575b600080fd5b61006b60048036038101906100669190610322565b6100eb565b005b610087600480360381019061008291906103c0565b61015d565b6040516100949190610408565b60405180910390f35b6100b760048036038101906100b29190610423565b610249565b6040516100c49190610472565b60405180910390f35b6100d56102a3565b6040516100e2919061049c565b60405180910390f35b6100f43361015d565b15610159576000338360405160200161010e9291906104c6565b6040516020818303038152906040528051906020012090508160008083815260200190815260200160002060006101000a81548163ffffffff021916908363ffffffff160217905550505b5050565b6000735b38da6a701c568545dcfcb03fcb875f56beddc473ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614156101b05760019050610244565b73235d39cda65c223611ea2a914fd686307ff389a473ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614156102015760019050610244565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16141561023f5760019050610244565b600090505b919050565b600080828460405160200161025f9291906104c6565b60405160208183030381529060405280519060200120905060008082815260200190815260200160002060009054906101000a900463ffffffff1691505092915050565b600033905090565b600080fd5b6000819050919050565b6102c3816102b0565b81146102ce57600080fd5b50565b6000813590506102e0816102ba565b92915050565b600063ffffffff82169050919050565b6102ff816102e6565b811461030a57600080fd5b50565b60008135905061031c816102f6565b92915050565b60008060408385031215610339576103386102ab565b5b6000610347858286016102d1565b92505060206103588582860161030d565b9150509250929050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061038d82610362565b9050919050565b61039d81610382565b81146103a857600080fd5b50565b6000813590506103ba81610394565b92915050565b6000602082840312156103d6576103d56102ab565b5b60006103e4848285016103ab565b91505092915050565b60008115159050919050565b610402816103ed565b82525050565b600060208201905061041d60008301846103f9565b92915050565b6000806040838503121561043a576104396102ab565b5b6000610448858286016102d1565b9250506020610459858286016103ab565b9150509250929050565b61046c816102e6565b82525050565b60006020820190506104876000830184610463565b92915050565b61049681610382565b82525050565b60006020820190506104b1600083018461048d565b92915050565b6104c0816102b0565b82525050565b60006040820190506104db600083018561048d565b6104e860208301846104b7565b939250505056fea26469706673582212203016d1accb2149379d87921d7b0ff76721ce9c7d800f2281961f7ea81b031ff764736f6c634300080c0033";

    public static final String FUNC_HASWRITEPRIVILEGE = "hasWritePrivilege";

    public static final String FUNC_RETRIEVE = "retrieve";

    public static final String FUNC_STORE = "store";

    public static final String FUNC_WHOAMI = "whoAmI";

    @Deprecated
    protected Contract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Contract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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
    public static Contract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Contract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Contract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Contract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Contract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Contract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Contract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Contract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Contract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Contract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Contract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Contract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
