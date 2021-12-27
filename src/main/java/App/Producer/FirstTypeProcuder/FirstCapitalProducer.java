package App.Producer.FirstTypeProcuder;

import App.HashMD5.hashMD5;
import App.Helpers.ToFirstCapitalConverter;
import App.Resource.Resource;
import lombok.*;

import java.util.List;

@AllArgsConstructor
public class FirstCapitalProducer implements Runnable {

    private List<String> words;

    private List<String> passwords;

    private Resource resource;

    @Override
    public void run() {

        while (!Thread.interrupted()) {
            for (String password : passwords) {
                for (String word : words) {
                    word = ToFirstCapitalConverter.convert(word);
                    if (password.equals(hashMD5.stringToMD5(word))) {
                        resource.put(password);
                    }
                }
            }
            break;
        }
    }
}
