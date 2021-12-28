package App.FileManagment;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@AllArgsConstructor
public class FileReader {

    @SneakyThrows
    public static List<String> getWordsDataFromFile(String fileName) {
        List<String> listOfPasswords =  new ArrayList<>();
        return getDataToList(fileName, listOfPasswords);
    }

    private static List<String> getDataToList(String fileName, List<String> listOfPasswords) throws IOException, URISyntaxException {
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

    @SneakyThrows
    public static Set<String> getPasswordsDataFromFile(String fileName) {
        Set<String> setOfPasswords = Collections.synchronizedSet(new HashSet<>());
        return getDataToHashSet(fileName, setOfPasswords);
    }

    private static Set<String> getDataToHashSet(String fileName, Set<String> setOfPasswords) throws IOException, URISyntaxException {
        URL resource = FileReader.class.getClassLoader().getResource(fileName);

        BufferedReader reader = null;
        if (resource != null) {
            reader = Files.newBufferedReader(Paths.get(resource.toURI()));
        }
        if (reader != null) {
            reader.lines().forEach(setOfPasswords::add);
        }

        return setOfPasswords;
    }
}
