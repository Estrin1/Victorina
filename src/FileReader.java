
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
    public class FileReader {
        public static void main(String[] args) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get("file.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

