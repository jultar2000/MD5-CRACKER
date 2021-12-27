package App.Producers.SecondTypeProducers.BasicProducers;

import App.HashMD5.hashMD5;
import App.Resource.Resource;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class LowerCaseMergedProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        String word;
        while (!Thread.interrupted()) {
                for (int i = 0; i < words.size() - 1; i++) {
                    word = (words.get(i) + words.get(i + 1)).toLowerCase();
                    if (passwords.contains(hashMD5.stringToMD5(word))) {
                        passwords.remove(word);
                        resource.put(word);
                    }
                }
        }
    }
}
