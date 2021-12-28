package App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddNumsProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class LowerCaseMergedAddNumsProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int add_num = 0;
        String word;
        String first_word;
        String hashed_word;
        while (!Thread.interrupted()) {
            for (int j = 0; j < words.size() - 1; j++) {
                first_word = words.get(j);
                for (int i = j + 1; i < words.size(); i++) {
                    word = first_word + words.get(i);
                    word = Helper.convertToNumWordNum(word, add_num).toLowerCase();
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

