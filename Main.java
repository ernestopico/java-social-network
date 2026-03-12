import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        HashMap<Integer, Account> accountMap = new HashMap<>();
        try {
            Scanner fileScanner = new Scanner(new File("accounts.csv"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String username = parts[1].trim();
                Account acc = new Account(username);
                network.addAccount(acc);
                accountMap.put(id, acc);
            }
            fileScanner.close();

            Scanner adjScanner = new Scanner(new File("adjacency.csv"));
            while (adjScanner.hasNextLine()) {
                String line = adjScanner.nextLine();
                String[] parts = line.split(":");
                int mainID = Integer.parseInt(parts[0].trim());
                Account u = accountMap.get(mainID);
                if (parts.length > 1 && !parts[1].trim().isEmpty()) {
                    String[] neighbors = parts[1].trim().split(",");
                    for (String neighborIdStr : neighbors) {
                        int neighborId = Integer.parseInt(neighborIdStr.trim());
                        Account v = accountMap.get(neighborId);
                        network.addConnection(u, v);
                    }
                }
            }
            adjScanner.close();

            Account center = GraphAlgorithms.networkCenter(network);
            System.out.println("center: " + center);
            System.out.println("Eccentricity:" + center.eccentricity);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}