package App.Consumer;

import App.Resource.Resource;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer implements Runnable {

    private Resource resource;

    @Override
    public void run() {
        try {
            resource.display();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

