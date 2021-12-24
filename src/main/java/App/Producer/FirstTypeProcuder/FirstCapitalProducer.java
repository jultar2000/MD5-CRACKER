package App.Producer.FirstTypeProcuder;

import App.Consumer.Consumer;
import App.HashMD5.hashMD5;
import App.Resource.Resource;
import lombok.*;

import java.util.List;

@AllArgsConstructor
public class FirstCapitalProducer implements Runnable {

    private List<String> words;

    private List<String> passwords;

    private Resource resource;

    @Override
    public void run() {
            for (String password : passwords) {
                for (String word : words) {
                    String firstLetter = word.substring(0, 1).toUpperCase();
                    String otherLetters = word.substring(1).toLowerCase();
                    word = firstLetter + otherLetters;
                    if (password.equals(hashMD5.stringToMD5(word))) {
                        resource.put(password);
                    }
                }
            }
    }
}
