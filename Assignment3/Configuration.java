import java.io.*;

public class Configuration {
    private static Configuration uniqueInstance;
    private String playerColor = "black";   

    private Configuration() {
        loadFromFile("GameConfig.txt");         
    }

    public static Configuration getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Configuration();
        }
        return uniqueInstance;
    }

    private void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split("=");
                if (parts.length != 2) continue;
                if (parts[0].trim().equalsIgnoreCase("playerColor")) {
                    playerColor = parts[1].trim();
                }
            }
        } catch (IOException e) {
            System.out.println("Config file not found. Using defaults.");
        }
    }

    public String getPlayerColor() {
        return playerColor;
    }
}