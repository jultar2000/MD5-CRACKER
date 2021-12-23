package App.Producer.FirstTypeProcuder;

import App.Consumer.Consumer;
import App.HashMD5.hashMD5;
import lombok.*;

import java.util.List;

@AllArgsConstructor
public class UpperCaseProducer implements Runnable {

    private List<String> words;

    private Consumer consumer;

    private String password;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for(String word: words){
                if(password.equals(hashMD5.stringToMD5(word.toUpperCase()))) {
                    consumer.putAndDisplay(word);
                }
            }
        }
    }


}
