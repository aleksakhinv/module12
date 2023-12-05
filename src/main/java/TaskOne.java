public class TaskOne {
    public static void main(String[] args) {
        Thread printTime = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis() - startTime;
                System.out.println("Time passed " + (currentTime / 1000) + " sec");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        Thread printMessage = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Passed 5 sec");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        printTime.start();
        printMessage.start();
    }
}
