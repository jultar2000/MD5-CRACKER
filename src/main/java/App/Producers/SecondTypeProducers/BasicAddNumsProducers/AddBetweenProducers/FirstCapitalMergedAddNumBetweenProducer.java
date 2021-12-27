package App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddBetweenProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FirstCapitalMergedAddNumBetweenProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        String first_word;
        String second_word;
        String word;
        int add_num = 0;
        while (!Thread.interrupted()) {
            for (int i = 0; i < words.size() - 1; i++) {
                first_word = Helper.convertToFirstCapital(words.get(i));
                second_word = Helper.convertToFirstCapital(words.get(i + 1));
                word = Helper.convertToWordNumWord(first_word, second_word, add_num);
                if (passwords.contains(hashMD5.stringToMD5(word))) {
                    passwords.remove(word);
                    resource.put(word);
                }
            }
            add_num++;
        }
    }
}
