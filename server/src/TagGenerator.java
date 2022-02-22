import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;

public class TagGenerator {

    private HashChain hashchain;

    public TagGenerator(int seed, String algorithm) throws NoSuchAlgorithmException {
        hashchain = new HashChain(seed, algorithm);
    }

    public void generate(int n) { hashchain.generate(n); }

    public int fetchTag() {
        // Pulls the first 4 bytes from the hashchain entry, into an integer
        byte[] bytes = hashchain.fetchItem();
        return ByteBuffer.wrap(bytes).getInt();
    }
}
