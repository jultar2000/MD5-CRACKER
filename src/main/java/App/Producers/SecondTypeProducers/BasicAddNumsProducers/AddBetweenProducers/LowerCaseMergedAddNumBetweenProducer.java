package App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddBetweenProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class LowerCaseMergedAddNumBetweenProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int add_num = 0;
        String word;
        while (!Thread.interrupted()) {
                for (int i = 0; i < words.size() - 1; i++) {
                    word = Helper.convertToWordNumWord(words.get(i),words.get(i+1), add_num).toLowerCase();
                    if (passwords.contains(hashMD5.stringToMD5(word))) {
                        passwords.remove(word);
                        resource.put(word);
                    }
                }
                add_num++;
        }
    }
}
