package App.Producer.FirstTypeProcuder;

import App.Consumer.Consumer;
import App.HashMD5.hashMD5;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LowerCaseProducer implements Runnable {

    private List<String> words;

    private Consumer consumer;

    private String password;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for(String word: words){
                if(password.equals(hashMD5.stringToMD5(word.toLowerCase()))) {
                    consumer.putAndDisplay(word);
                }
            }
        }
    }
}
