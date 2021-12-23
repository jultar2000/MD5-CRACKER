package App.Consumer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Consumer {

    private final List<String> passwordsCracked;

    public Consumer() {
        this.passwordsCracked = new ArrayList<>();
    }

    public synchronized void putAndDisplay(String password) {
            if (!passwordsCracked.contains(password)) {
                passwordsCracked.add(password);
            }
            System.out.println(passwordsCracked);
    }
}
