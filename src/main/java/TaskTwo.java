import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskTwo {
    int counter = 1;
    int value;
    private final BlockingQueue<String> queueAll = new LinkedBlockingQueue<>();
    public TaskTwo(int value) {
        this.value = value;
    }

    public  synchronized void fizz() throws InterruptedException {
        while (counter <= value) {
            if (counter % 3 == 0 && counter % 5 != 0) {
                queueAll.put("fizz");
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public  synchronized void buzz() throws InterruptedException {
        while (counter <= value) {
            if (counter % 5 == 0 && counter % 3 != 0) {
                queueAll.put("buzz");
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public  synchronized void fizzBuzz() throws InterruptedException {
        while (counter <= value) {
            if (counter % 3 == 0 && counter % 5 == 0) {
                queueAll.put("fizzbuzz");
                counter++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public  synchronized void number() throws InterruptedException {
        while (counter <= value) {
            if (counter % 3 != 0 && counter % 5 != 0) {
                queueAll.put(String.valueOf(counter));
                counter++;
                notifyAll();
            }
            if (queueAll.size() == 0) {
                wait();
            }
            System.out.println(queueAll.poll());
        }
    }
}
