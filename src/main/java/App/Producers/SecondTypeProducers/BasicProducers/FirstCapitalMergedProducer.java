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
        while (!Thread.interrupted()) {
                for (int i = 0; i < words.size() - i - 1; i++) {
                    first_word = Helper.convertToFirstCapital(words.get(i));
                    second_word = Helper.convertToFirstCapital(words.get(i+1));
                    word = first_word + second_word;
                    if (passwords.contains(hashMD5.stringToMD5(word))) {
                        passwords.remove(word);
                        resource.put(word);
                    }
            }
        }
    }
}