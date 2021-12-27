package App.Producers.FirstTypeProcuders.BasicAddNumsProducers;

import App.HashMD5.hashMD5;
import App.Helpers.Helper;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class LowerCaseAddNumsProducer implements Runnable {

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int add_num = 0;
        while (!Thread.interrupted()) {
            for (String word : words) {
                word = Helper.convertToNumWordNum(word, add_num).toLowerCase();
                if (passwords.contains(hashMD5.stringToMD5(word))) {
                    passwords.remove(word);
                    resource.put(word);
                }
            }
            add_num++;
        }
    }
}