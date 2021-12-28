package App.Producers.SecondTypeProducers.BasicAddSpecialBetweenProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class LowerCaseMergedAddSpecialBetweenProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        List<Character> signsList = Arrays.asList('/', '?', '*', '|', '@', '!', '%', '$', '#', ',', '.', '^');
        String hashed_word;
        String first_word;
        String second_word;
        String word;
        while (!Thread.interrupted()) {
            for (int j = 0; j < words.size() - 1; j++) {
                first_word = words.get(j);
                for (int i = j + 1; i < words.size(); i++) {
                    second_word = words.get(i);
                    for (Character character : signsList) {
                        word = Helper.convertToWordSignWord(first_word, second_word, character).toLowerCase();
                        hashed_word = hashMD5.stringToMD5(word);
                        if (passwords.contains(hashed_word)) {
                            passwords.remove(hashed_word);
                            resource.put(word);
                        }
                    }
                }
            }
        }
    }
}
