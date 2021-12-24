package App.FileManagment;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    @SneakyThrows
    public static List<String> getAllDataFromFile(String fileName) {
        List<String> listOfPasswords = new ArrayList<>();
        URL resource = FileReader.class.getClassLoader().getResource(fileName);

        BufferedReader reader = null;
        if (resource != null) {
            reader = Files.newBufferedReader(Paths.get(resource.toURI()));
        }
        if (reader != null) {
            reader.lines().forEach(listOfPasswords::add);
        }
        return listOfPasswords;
    }

}
