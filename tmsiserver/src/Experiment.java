import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class Experiment {
    public Experiment(File file) throws IOException {

        int numSamples = 100000;

        String[] algorithms = new String[]{"MD5", "SHA-224", "SHA-256", "SHA-384", "SHA-512"}; //, "SHA3-224", "SHA3-256", "SHA3-384", "SHA3-512"};
        int[] hashchainSizes = new int[]{1, 10, 100, 1000};


        FileWriter output = new FileWriter(file);

        String header = "";
        header += "Algorithm (samples=" + numSamples + "),";
        //header += "Initialization (internal timer) (ns),";
        header += "Initialization (ns),";
        //header += "Item Fetching (internal timer) (ns),";
        header += "Item Fetching (ns),";
        header += "Individual Hash (ns),";
        header += "Hash Verification (ns),";
        for(int i = 0; i < hashchainSizes.length; i++) {
            //header += "Gen n=" + hashchainSizes[i] + " (internal timer) (ns),";
            header += "Gen n=" + hashchainSizes[i] + " (ns),";
        }
        //header += "Putting into packet (internal timer) (ns),";
        header += "Putting into packet (ns),";
        output.write(header + "\n");

        HashChain hashchain;

        for(int i = 0; i < algorithms.length; i++) {
            if(algorithms[i] != "SHA-256") {
                // Skip all non SHA-256 algorithms
                String line = "";
                line += algorithms[i] + ",";
                line += "0,";
                line += "0,";
                line += "0,";
                line += "0,";
                for(int j = 0; j < hashchainSizes.length; j++) {
                    line += "0,";
                }
                line += "0,";
                output.write(line + "\n");
                continue;
            }
            try {
                hashchain = new HashChain(54321, algorithms[i]);
            } catch (NoSuchAlgorithmException e) {
                continue;
            }

            //long initializationTimeInternal = InternalInitializationExperiment(algorithms[i], numSamples);
            long initializationTimeExternal = ExternalInitializationExperiment(algorithms[i], numSamples);

            //long fetchDurationInternal = InternalFetchTimerExperiment(hashchain, numSamples);
            long fetchDurationExternal = ExternalFetchTimerExperiment(hashchain, numSamples);
            
            long invididualHash = IndividualHashTimerExperiment(algorithms[i], numSamples);
            long hashVerify = HashVerifyTimerExperiment(algorithms[i], numSamples);

            String line = "";
            line += algorithms[i] + ",";
            //line += initializationTimeInternal + ",";
            line += initializationTimeExternal + ",";
            //line += fetchDurationInternal + ",";
            line += fetchDurationExternal + ",";
            
            line += invididualHash + ",";
            line += hashVerify + ",";

            // SKIP EVERYTHING ELSE
//            if(1 == 1) {
//                for (int j = 0; j < hashchainSizes.length; j++) {
//                    line += "0,";
//                }
//                line += "0,";
//                output.write(line + "\n");
//                continue;
//            }


            for(int j = 0; j < hashchainSizes.length; j++) {
                //long generateInternal = InternalGenTimerExperiment(hashchain, hashchainSizes[j], numSamples);
                long generateExternal = ExternalGenTimerExperiment(hashchain, hashchainSizes[j], numSamples);
                //line += generateInternal + ",";
                line += generateExternal + ",";
            }

            hashchain.generate(1);
            byte[] bytes = hashchain.fetchItem();
            //long packetDurationInternal = InternalPacketTimerExperiment(bytes, numSamples);
            long packetDurationExternal = ExternalPacketTimerExperiment(bytes, numSamples);

            //line += packetDurationInternal + ",";
            line += packetDurationExternal + ",";

            output.write(line + "\n");
        }

        output.close();
    }

//    private long InternalInitializationExperiment(String algorithm, int numSamples) {
//        long fetchDuration = 0, startTime, endTime;
//        for (int j = 0; j < numSamples; j++) {
//            startTime = System.nanoTime();
//            try {
//                HashChain hashchain = new HashChain(54321, algorithm);
//            } catch (NoSuchAlgorithmException e) {
//            }
//            endTime = System.nanoTime();
//            fetchDuration += (endTime - startTime);
//        }
//        fetchDuration /= numSamples;
//        return fetchDuration;
//    }

    private long ExternalInitializationExperiment(String algorithm, int numSamples) {
        long fetchDuration = 0, startTime, endTime;
        startTime = System.nanoTime();
        for (int j = 0; j < numSamples; j++) {
            try {
                HashChain hashchain = new HashChain(54321, algorithm);
            } catch (NoSuchAlgorithmException e) {
            }
        }
        endTime = System.nanoTime();
        fetchDuration = (endTime - startTime) / numSamples;
        return fetchDuration;
    }

//    private long InternalFetchTimerExperiment(HashChain hashchain, int numSamples) {
//        hashchain.generate(numSamples); // So we don't run out of fetches
//        long fetchDuration = 0, startTime, endTime;
//        byte[] bytes;
//        for (int j = 0; j < numSamples; j++) {
//            startTime = System.nanoTime();
//            bytes = hashchain.fetchItem();
//            endTime = System.nanoTime();
//            fetchDuration += (endTime - startTime);
//        }
//        fetchDuration /= numSamples;
//        return fetchDuration;
//    }

    private long ExternalFetchTimerExperiment(HashChain hashchain, int numSamples) {
        hashchain.generate(numSamples); // So we don't run out of fetches
        long fetchDuration = 0, startTime, endTime;
        byte[] bytes;
        startTime = System.nanoTime();
        for (int j = 0; j < numSamples; j++) {
            bytes = hashchain.fetchItem();
        }
        endTime = System.nanoTime();
        fetchDuration = (endTime - startTime) / numSamples;
        return fetchDuration;
    }

    private long IndividualHashTimerExperiment(String algorithm, int numSamples) {
        long startTime, endTime;
        byte[] temp, input = "hello".getBytes(StandardCharsets.UTF_8);
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            return 0;
        }
        startTime = System.nanoTime();
        for (int j = 0; j < numSamples; j++) {
            temp = digest.digest(input);
        }
        endTime = System.nanoTime();
        return (endTime - startTime) / numSamples;
    }

    private long HashVerifyTimerExperiment(String algorithm, int numSamples) {
        long startTime, endTime;
        byte[] temp1, temp2;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            return 0;
        }
        temp1 = digest.digest("hello".getBytes(StandardCharsets.UTF_8));
        Boolean equal;
        startTime = System.nanoTime();
        for (int j = 0; j < numSamples; j++) {
            temp2 = digest.digest("world".getBytes(StandardCharsets.UTF_8));
            equal = temp1 == temp2;
        }
        endTime = System.nanoTime();
        return (endTime - startTime) / numSamples;
    }

//    private long InternalGenTimerExperiment(HashChain hashchain, int size, int numSamples) {
//        long generateDuration = 0, startTime, endTime;
//        for (int k = 0; k < numSamples; k++) {
//            startTime = System.nanoTime();
//            hashchain.generate(size);
//            endTime = System.nanoTime();
//            generateDuration += (endTime - startTime);
//        }
//        generateDuration /= numSamples;
//        return generateDuration;
//    }

    private long ExternalGenTimerExperiment(HashChain hashchain, int size, int numSamples) {
        long generateDuration = 0, startTime, endTime;
        startTime = System.nanoTime();
        for (int k = 0; k < numSamples; k++) {
            hashchain.generate(size);
        }
        endTime = System.nanoTime();
        generateDuration = (endTime - startTime) / numSamples;
        return generateDuration;
    }


//    private long InternalPacketTimerExperiment(byte[] bytes, int numSamples) {
//        long generateDuration = 0, startTime, endTime;
//        try {
//            for (int k = 0; k < numSamples; k++) {
//                startTime = System.nanoTime();
//
//                InetAddress address = InetAddress.getByName("127.0.0.1");
//                int port = 1234;
//                DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, port);
//
//                endTime = System.nanoTime();
//                generateDuration += (endTime - startTime);
//            }
//            generateDuration /= numSamples;
//        } catch (UnknownHostException e) {
//            return -1;
//        }
//        return generateDuration;
//    }


    private long ExternalPacketTimerExperiment(byte[] bytes, int numSamples) {
        long generateDuration = 0, startTime, endTime;
        try {
            startTime = System.nanoTime();
            for (int k = 0; k < numSamples; k++) {
                InetAddress address = InetAddress.getByName("127.0.0.1");
                int port = 1234;
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, port);
            }
            endTime = System.nanoTime();
            generateDuration = (endTime - startTime) / numSamples;
        } catch (UnknownHostException e) {
            return -1;
        }
        return generateDuration;
    }

}
