package App.Resource;

import java.util.ArrayList;
import java.util.List;

public class Resource {

    private final List<String> passwordsCracked = new ArrayList<>();

    private String newCrackedPassword;

    public synchronized void display() throws InterruptedException {
        while (newCrackedPassword == null) {
            wait();
        }
        newCrackedPassword = null;
        System.out.println(passwordsCracked);
    }

    public synchronized void put(String password) {
        passwordsCracked.add(password);
        newCrackedPassword = password;
        notify();
    }
}
