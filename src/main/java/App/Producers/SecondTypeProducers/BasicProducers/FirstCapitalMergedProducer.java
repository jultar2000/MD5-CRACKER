package App.Producers.SecondTypeProducers.BasicProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FirstCapitalMergedProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        String first_word;
        String second_word;
        String word;
        String hashed_word;
        while (!Thread.interrupted()) {
            for (int j = 0; j < words.size() - 1; j++) {
                first_word = Helper.convertToFirstCapital(words.get(j));
                for (int i = j + 1; i < words.size(); i++) {
                    second_word = Helper.convertToFirstCapital(words.get(i));
                    word = first_word + second_word;
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