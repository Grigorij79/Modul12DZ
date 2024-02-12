public class Metod2 implements Runnable{

    @Override
    public void run() {
        int day = 0;
        int hour = 0;
        int minutes = 0;
        int seconds = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                 seconds++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if ( seconds == 60) { seconds =0;
                minutes++;
            }
            if (minutes ==60) {  minutes = 0;
                hour++;
            }
            if (hour == 24) {  hour = 0;
                day ++;
            }
            System.out.println(" Від моменту запуску програми минуло; " + day
                    + " Днів " + hour + " годин " + minutes + " хвилин " + seconds + " секунд");

        }
    }

}
