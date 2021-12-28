package App.Resource;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Resource {

    private final List<String> passwordsCracked = new ArrayList<>();

    private String newCrackedPassword;

    public synchronized void display() throws InterruptedException {
        while (newCrackedPassword == null) {
            wait();
        }
        System.out.println("New password found!");
        System.out.println(newCrackedPassword);
        newCrackedPassword = null;
    }

    public synchronized void put(String password) {
        passwordsCracked.add(password);
        newCrackedPassword = password;
        notifyAll();
    }

    public void displayAll(){
        System.out.println("Final passwords cracked: ");
        System.out.println(passwordsCracked);
    }
}
