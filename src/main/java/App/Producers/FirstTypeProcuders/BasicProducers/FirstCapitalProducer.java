package App.Producers.FirstTypeProcuders.BasicProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FirstCapitalProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        String hashed_word;
        while (!Thread.interrupted()) {
                for (String word : words) {
                    word = Helper.convertToFirstCapital(word);
                    hashed_word = hashMD5.stringToMD5(word);
                    if (passwords.contains(hashed_word)) {
                        passwords.remove(hashed_word);
                        resource.put(word);
                    }
            }
            break;
        }
    }
}
