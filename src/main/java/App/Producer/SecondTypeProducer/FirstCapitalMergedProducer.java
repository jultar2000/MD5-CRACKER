package App.Producer.SecondTypeProducer;

import App.HashMD5.hashMD5;
import App.Helpers.ToFirstCapitalConverter;
import App.Resource.Resource;
import lombok.*;

import java.util.List;

@AllArgsConstructor
public class FirstCapitalMergedProducer implements Runnable {

    private List<String> words;

    private List<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int j = 1;
        while (!Thread.interrupted()) {
            for (String password : passwords) {
                for (int i = 0; i < words.size() - 1; i++) {
                    String first_word = words.get(i);
                    first_word = ToFirstCapitalConverter.convert(first_word);
                    String second_word = words.get(i);
                    second_word = ToFirstCapitalConverter.convert(second_word);
                    String word = first_word + second_word;
                    if (password.equals(hashMD5.stringToMD5(word))) {
                        resource.put(word);
                    }
                    j++;
                }
                j = 1;
            }
        }
    }
}