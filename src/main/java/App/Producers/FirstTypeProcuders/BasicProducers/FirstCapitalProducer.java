package App.Producers.FirstTypeProcuders.BasicProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FirstCapitalProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
                for (String word : words) {
                    word = Helper.convertToFirstCapital(word);
                    if (passwords.contains(hashMD5.stringToMD5(word))) {
                        passwords.remove(word);
                        resource.put(word);
                    }
            }
            break;
        }
    }
}
