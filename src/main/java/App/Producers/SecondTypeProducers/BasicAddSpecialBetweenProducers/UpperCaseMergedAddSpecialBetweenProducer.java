package App.Producers.SecondTypeProducers.BasicAddSpecialBetweenProducers;

import App.Resource.Resource;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class UpperCaseMergedAddSpecialBetweenProducer implements Runnable{

    private List<String> words;

    private Set<String> passwords;

    private Resource resource;

    @Override
    public void run() {

    }
}
