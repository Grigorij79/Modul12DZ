public class Metod1 implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Минуло 5 секунд");
        }
    }

 }
