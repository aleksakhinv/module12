public class TaskTwoDemo {
    public static void main(String[] args) {
        TaskTwo task = new TaskTwo(20);
        Thread threadA = new Thread(() -> {
            try {
                task.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                task.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                task.fizzBuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadD= new Thread(() -> {
            try {
                task.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
