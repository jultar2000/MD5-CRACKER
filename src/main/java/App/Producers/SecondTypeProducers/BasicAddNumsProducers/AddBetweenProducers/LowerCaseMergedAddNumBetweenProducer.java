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
        String hashed_word;
        String first_word;
        while (!Thread.interrupted()) {
            for (int j = 0; j < words.size() - 1; j++) {
                first_word = words.get(j);
                for (int i = j + 1; i < words.size(); i++) {
                    word = Helper.convertToWordNumWord(first_word, words.get(i), add_num).toLowerCase();
                    hashed_word = hashMD5.stringToMD5(word);
                    if (passwords.contains(hashed_word)) {
                        passwords.remove(hashed_word);
                        resource.put(word);
                    }
                }
            }
            add_num++;
        }
    }
}
