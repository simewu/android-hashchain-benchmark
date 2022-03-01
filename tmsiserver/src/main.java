
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class main {
    public static void main(String args[]) throws IOException {
        System.out.println("Hello!");
        try {
            File file = new File("benchmarkOutputServer.csv");
            Experiment experiment = new Experiment(file);
        } catch (IOException e) {
            return;
        }
    }
}
