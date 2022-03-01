
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class HashChain {
    private int seed;
    private String algorithm;
    private ArrayList<byte[]> hashchain;

    public HashChain(int seed, String algorithm) throws NoSuchAlgorithmException {
        this.seed = seed;
        this.algorithm = algorithm;
        this.hashchain = new ArrayList<>();

        // Tests that the algorithm does indeed work
        MessageDigest digest = MessageDigest.getInstance(algorithm);
    }

    // By default, generate a hashchain of length 1000000 + 1 (for the initial value)
    public void generate() { generate(1000000); }

    public void generate(int n) {
        this.hashchain.clear();

        byte[] newHash;
        byte[] prevHash = ByteBuffer.allocate(4).putInt(this.seed).array();

        for(int i = 0; i < n; i++) {
            newHash = hash(prevHash, this.algorithm);
            this.hashchain.add(0, newHash);
            prevHash = newHash;
        }
    }

    public byte[] hash(String input, String algorithm) {
        return hash(input.getBytes(StandardCharsets.UTF_8), algorithm);
    }

    public byte[] hash(byte[] input, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            return digest.digest(input);
        } catch (NoSuchAlgorithmException e) {
            return new byte[0];
        }
    }

    // Pulls an entry out of the hashchain
    byte[] fetchItem() {
        if(hashchain.size() == 0) {
            return new byte[0];
        } else {
            return hashchain.remove(0);
        }
    }
}
