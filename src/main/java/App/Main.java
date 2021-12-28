package App;

import App.FileManagment.FileReader;
import App.Helpers.ThreadsInitializer;
import App.Resource.Resource;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> setOfPasswords;
        List<Thread> listOfThreads;
        List<String> listOfWords;

        String passwordsFileName = "passwords3.txt";
        String wordsFileName = "dictionary.txt";
        Scanner scanner = new Scanner(System.in);

        //default configuration
        setOfPasswords = FileReader.getPasswordsDataFromFile(passwordsFileName);
        listOfWords = FileReader.getWordsDataFromFile(wordsFileName);

        while (true) {
            Resource resource = new Resource();

            //initialize threads and add them to the list
            listOfThreads = ThreadsInitializer.initializeThreads(listOfWords, setOfPasswords, resource);

            //start threads
            listOfThreads.forEach(Thread::start);

            System.out.println("Pass the name of the passwords file to crack:");
            passwordsFileName = scanner.nextLine();
            setOfPasswords = FileReader.getPasswordsDataFromFile(passwordsFileName);

            //stop threads
            listOfThreads.forEach(Thread::interrupt);
        }
    }
}
