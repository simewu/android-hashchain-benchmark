
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class main {
    public static void main(String args[]) throws IOException {
        System.out.println("Beginning experiment...");
        try {
            File file = new File("benchmarkOutputServer.csv");
            Experiment experiment = new Experiment(file);
            System.out.println("Experiment completed successfully!");
        } catch (IOException e) {
            System.out.println("Experiment ran into an error.");
            return;
        }
    }
}
