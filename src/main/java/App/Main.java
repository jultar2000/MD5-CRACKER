package App;

import App.Consumer.Consumer;
import App.Producer.FirstTypeProcuder.LowerCaseProducer;
import App.Producer.FirstTypeProcuder.UpperCaseProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<String> listOfPasswords = new ArrayList<>();
        List<String> listOfWords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

//    System.out.println("Pass the name of the passwords resource: ");
//    //String fileName = scanner.nextLine();
//    listOfPasswords = FileReader.getAllDataFromFile("passwords.txt");
//    listOfWords = FileReader.getAllDataFromFile("dictionary.txt");
//    System.out.println(listOfPasswords);

        listOfPasswords.add("8621ffdbc5698829397d97767ac13db3");
        listOfPasswords.add("276f8db0b86edaa7fc805516c852c889");
        listOfWords.add("dragon");
        listOfWords.add("DRAGON");
        listOfWords.add("baseball");

        Consumer consumer = new Consumer();
        Thread thread1 = new Thread(new LowerCaseProducer(listOfWords, consumer, listOfPasswords.get(0)));
        Thread thread2 = new Thread(new UpperCaseProducer(listOfWords, consumer, listOfPasswords.get(0)));

        thread1.start();
        thread2.start();

    }
}
