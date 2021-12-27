package App.Producers.FirstTypeProcuders.BasicProducers;

import App.HashMD5.hashMD5;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class LowerCaseProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (String word : words) {
                word = word.toLowerCase();
                if (passwords.contains(hashMD5.stringToMD5(word))) {
                    passwords.remove(word);
                    resource.put(word);
                }
            }
            break;
        }
    }
}