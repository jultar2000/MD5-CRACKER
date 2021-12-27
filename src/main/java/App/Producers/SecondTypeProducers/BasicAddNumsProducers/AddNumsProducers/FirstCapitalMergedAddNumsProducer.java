package App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddNumsProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FirstCapitalMergedAddNumsProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int j = 1;
        String first_word;
        String second_word;
        String word;
        while (!Thread.interrupted()) {
            int add_num=0;
            for (String password : passwords) {
                for (int i = 0; i < words.size() - 1; i++) {
                    first_word = Helper.convertToFirstCapital(words.get(i));
                    second_word = Helper.convertToFirstCapital(words.get(j));
                    word = first_word + second_word;
                    word = Helper.convertToNumWordNum(word, add_num);
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
