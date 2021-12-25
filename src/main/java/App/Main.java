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

        List<String> listOfWords;
        List<String> listOfPasswords;
        List<Thread> listOfThreads;
        String passwordsFileName = "passwords.txt";
        Scanner scanner = new Scanner(System.in);

        //default configuration
        listOfWords = FileReader.getAllDataFromFile("dictionary.txt");
        listOfPasswords = FileReader.getAllDataFromFile(passwordsFileName);

        while (true) {
            listOfThreads = new ArrayList<>();
            //initialize consumer
            Resource resource = new Resource();

            //initialize threads and add them to the list
            listOfThreads.add(new Thread(new LowerCaseProducer(listOfWords, listOfPasswords, resource)));
            listOfThreads.add(new Thread(new UpperCaseProducer(listOfWords, listOfPasswords, resource)));
            listOfThreads.add(new Thread(new FirstCapitalProducer(listOfWords, listOfPasswords, resource)));
            listOfThreads.add(new Thread(new Consumer(resource)));

            //start threads
            listOfThreads.forEach(Thread::start);

            System.out.println("Pass the name of the passwords file to crack:");
            passwordsFileName = scanner.nextLine();
            listOfPasswords = FileReader.getAllDataFromFile(passwordsFileName);

            listOfThreads.forEach(Thread::interrupt);
        }
    }
}
