package App.Producers.FirstTypeProcuders.BasicAddNumsProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FirstCapitalAddNumsProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int add_num = 0;
        String hashed_word;
        while (!Thread.interrupted()) {
            for (String word : words) {
                word = Helper.convertToFirstCapital(word);
                word = Helper.convertToNumWordNum(word, add_num);
                hashed_word = hashMD5.stringToMD5(word);
                if (passwords.contains(hashed_word)) {
                    passwords.remove(hashed_word);
                    resource.put(word);
                }
            }
            add_num++;
        }
    }
}