package App.Producer.FirstTypeProcuder;

import App.HashMD5.hashMD5;
import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LowerCaseProducer implements Runnable {

    private List<String> words;

    private List<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        int add_num = 0;
        while (!Thread.interrupted()) {
            for (String password : passwords) {
                for (String word : words) {
                    String word_tmp = add_num + word + add_num;
                    if (word_tmp.equals(hashMD5.stringToMD5(password.toLowerCase()))) {
                        resource.put(word);
                    }
                }
            }
            add_num++;
        }
    }
}