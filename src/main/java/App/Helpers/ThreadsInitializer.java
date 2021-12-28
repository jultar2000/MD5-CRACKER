package App.Helpers;

import App.Consumer.Consumer;
import App.Producers.FirstTypeProcuders.BasicAddNumsProducers.FirstCapitalAddNumsProducer;
import App.Producers.FirstTypeProcuders.BasicAddNumsProducers.LowerCaseAddNumsProducer;
import App.Producers.FirstTypeProcuders.BasicAddNumsProducers.UpperCaseAddNumsProducer;
import App.Producers.FirstTypeProcuders.BasicProducers.FirstCapitalProducer;
import App.Producers.FirstTypeProcuders.BasicProducers.LowerCaseProducer;
import App.Producers.FirstTypeProcuders.BasicProducers.UpperCaseProducer;
import App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddBetweenProducers.FirstCapitalMergedAddNumBetweenProducer;
import App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddBetweenProducers.LowerCaseMergedAddNumBetweenProducer;
import App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddBetweenProducers.UpperCaseMergedAddNumBetweenProducer;
import App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddNumsProducers.FirstCapitalMergedAddNumsProducer;
import App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddNumsProducers.LowerCaseMergedAddNumsProducer;
import App.Producers.SecondTypeProducers.BasicAddNumsProducers.AddNumsProducers.UpperCaseMergedAddNumsProducer;
import App.Producers.SecondTypeProducers.BasicAddSpecialBetweenProducers.FirstCapitalMergedAddSpecialBetweenProducer;
import App.Producers.SecondTypeProducers.BasicAddSpecialBetweenProducers.LowerCaseMergedAddSpecialBetweenProducer;
import App.Producers.SecondTypeProducers.BasicAddSpecialBetweenProducers.UpperCaseMergedAddSpecialBetweenProducer;
import App.Producers.SecondTypeProducers.BasicProducers.FirstCapitalMergedProducer;
import App.Producers.SecondTypeProducers.BasicProducers.LowerCaseMergedProducer;
import App.Producers.SecondTypeProducers.BasicProducers.UpperCaseMergedProducer;
import App.Resource.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ThreadsInitializer {

    public static List<Thread> initializeThreads(List<String> listOfWords,
                                                 Set<String> setOfPasswords,
                                                 Resource resource) {

        List<Thread> listOfThreads = new ArrayList<>();

        //First type basic producers
        listOfThreads.add(new Thread(new LowerCaseProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new UpperCaseProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new FirstCapitalProducer(listOfWords, setOfPasswords, resource)));

        //First type add nums producers
        listOfThreads.add(new Thread(new LowerCaseAddNumsProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new UpperCaseAddNumsProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new FirstCapitalAddNumsProducer(listOfWords, setOfPasswords, resource)));

        //Second type basic producers
        listOfThreads.add(new Thread(new LowerCaseMergedProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new UpperCaseMergedProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new FirstCapitalMergedProducer(listOfWords, setOfPasswords, resource)));

        //Second type add nums producers
        listOfThreads.add(new Thread(new LowerCaseMergedAddNumsProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new UpperCaseMergedAddNumsProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new FirstCapitalMergedAddNumsProducer(listOfWords, setOfPasswords, resource)));

        //Second type add between producers
        listOfThreads.add(new Thread(new LowerCaseMergedAddNumBetweenProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new UpperCaseMergedAddNumBetweenProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new FirstCapitalMergedAddNumBetweenProducer(listOfWords, setOfPasswords, resource)));

        //Second type add special between producers
        listOfThreads.add(new Thread(new LowerCaseMergedAddSpecialBetweenProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new UpperCaseMergedAddSpecialBetweenProducer(listOfWords, setOfPasswords, resource)));
        listOfThreads.add(new Thread(new FirstCapitalMergedAddSpecialBetweenProducer(listOfWords, setOfPasswords, resource)));

        listOfThreads.add(new Thread(new Consumer(resource)));

        return listOfThreads;
    }
}
