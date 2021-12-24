package App;

import App.Consumer.Consumer;
import App.FileManagment.FileReader;
import App.Producer.FirstTypeProcuder.FirstCapitalProducer;
import App.Producer.FirstTypeProcuder.LowerCaseProducer;
import App.Producer.FirstTypeProcuder.UpperCaseProducer;
import App.Resource.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> listOfPasswords;
        List<String> listOfWords;
        List<Thread> listOfThreads = new ArrayList<>();
//      Scanner scanner = new Scanner(System.in);
//      System.out.println("Pass the name of the passwords resource: ");
//      String fileName = scanner.nextLine();
        listOfPasswords = FileReader.getAllDataFromFile("passwords.txt");
        listOfWords = FileReader.getAllDataFromFile("dictionary.txt");

        //initialize consumer
        Resource resource = new Resource();

        //initialize threads and add them to the list
        listOfThreads.add(new Thread(new LowerCaseProducer(listOfWords, listOfPasswords, resource)));
        listOfThreads.add(new Thread(new UpperCaseProducer(listOfWords, listOfPasswords, resource)));
        listOfThreads.add(new Thread(new FirstCapitalProducer(listOfWords, listOfPasswords, resource)));
        Thread consumerThread = new Thread(new Consumer(resource));

        //start threads
        consumerThread.start();
        listOfThreads.forEach(Thread::start);
    }
}
