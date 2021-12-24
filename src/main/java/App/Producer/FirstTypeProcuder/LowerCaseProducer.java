package App.Producer.FirstTypeProcuder;

import App.Consumer.Consumer;
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
            for (String password : passwords) {
                for (String word : words) {
                    if (password.equals(hashMD5.stringToMD5(word.toLowerCase()))) {
                        resource.put(word);
                    }
                }
            }
    }
}