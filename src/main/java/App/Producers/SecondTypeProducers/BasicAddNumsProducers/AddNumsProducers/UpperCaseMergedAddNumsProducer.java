package App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddNumsProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class UpperCaseMergedAddNumsProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int j = 1;
        int add_num = 0;
        String word;
        while (!Thread.interrupted()) {
            for (String password : passwords) {
                for (int i = 0; i < words.size() - 1; i++) {
                    word = words.get(i) + words.get(j);
                    word = Helper.convertToNumWordNum(word, add_num).toUpperCase();
                    if (password.equals(hashMD5.stringToMD5(word))) {
                        passwords.remove(password);
                        resource.put(word);
                    }
                    j++;
                }
                j = 1;
                add_num++;
            }
        }
    }
}
