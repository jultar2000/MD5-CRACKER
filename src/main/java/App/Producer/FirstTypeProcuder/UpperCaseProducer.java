package App.Producer.FirstTypeProcuder;

import App.HashMD5.hashMD5;
import App.Resource.Resource;
import lombok.*;

import java.util.List;

@AllArgsConstructor
public class UpperCaseProducer implements Runnable {

    private List<String> words;

    private List<String> passwords;

    private Resource resource;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (String password : passwords) {
                for (String word : words) {
                    if (password.equals(hashMD5.stringToMD5(word.toUpperCase()))) {
                        resource.put(word);
                    }
                }
            }
            break;
        }
    }
}
