import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Application {
    public static void main(String[] args) {
        String inputFilePath = "input.json";
        String outputFilePath = "output.txt";
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            JsonNode rootNode = objectMapper.readTree(new File(inputFilePath));

            String firstName = rootNode.path("student").path("first_name").asText();
            String rollNumber = rootNode.path("student").path("roll_number").asText();

            String concatenatedString = firstName + rollNumber;

            String md5Hash = generateMD5Hash(concatenatedString);

            try (FileWriter writer = new FileWriter(outputFilePath)) {
                writer.write("MD5 Hash: " + md5Hash);
            }

            System.out.println("MD5 Hash has been written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }

    private static String generateMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}