package App.Producer.SecondTypeProducer;

import App.HashMD5.hashMD5;
import App.Resource.Resource;
import lombok.*;

import java.util.List;

@AllArgsConstructor
public class UpperCaseMergedProducer implements Runnable {

    private List<String> words;

    private List<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int j = 1;
        while (!Thread.interrupted()) {
            for (String password : passwords) {
                for (int i = 0; i < words.size() - 1; i++) {
                    String word = words.get(i) + words.get(j);
                    if (password.equals(hashMD5.stringToMD5(word.toUpperCase()))) {
                        resource.put(word);
                    }
                    j++;
                }
                j = 1;
            }
        }
    }
}
