import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class main {
    public static void main(String args[]) throws IOException {

        int numSamples = 1000;

        String[] algorithms = new String[]{"MD5", "SHA-256", "SHA-512", "SHA3-256", "Keccak-256"};
        int[] hashchainSizes = new int[]{1, 10, 100, 1000};


        FileWriter output = new FileWriter("benchmarkOutput.csv");

        String header = "";
        header += "Algorithm (samples=" + numSamples + "),";
        header += "Item Fetching (ns),";
        for(int i = 0; i < hashchainSizes.length; i++) {
            header += "Gen n=" + hashchainSizes[i] + " (ns),";
        }
        output.write(header + "\n");


        for(int i = 0; i < algorithms.length; i++) {
            TagGenerator tg;
            try {
                tg = new TagGenerator(0, algorithms[i]);
            } catch (NoSuchAlgorithmException e) {
                continue;
            }

            tg.generate(numSamples); // So we don't run out of fetches
            long fetchDuration = 0;
            for (int j = 0; j < numSamples; j++) {
                long startTime = System.nanoTime();
                tg.fetchTag();
                long endTime = System.nanoTime();
                fetchDuration += (endTime - startTime);
            }
            fetchDuration /= numSamples;
            //generateDuration /= 1000000; // Nanoseconds to milliseconds

            String line = "";
            line += algorithms[i] + ",";
            line += fetchDuration + ",";

            for(int j = 0; j < hashchainSizes.length; j++) {
                long generateDuration = 0;
                for (int k = 0; k < numSamples; k++) {
                    long startTime = System.nanoTime();
                    tg.generate(hashchainSizes[j]);
                    long endTime = System.nanoTime();
                    generateDuration += (endTime - startTime);
                }
                generateDuration /= numSamples;
                //generateDuration /= 1000000; // Nanoseconds to milliseconds
                line += generateDuration + ",";
            }

            output.write(line + "\n");
        }


        output.close();
    }

}
