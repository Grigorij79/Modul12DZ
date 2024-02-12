public class Zad1 {
    static int n = 10;
      public static void main(String[] args) {

        Metod1 metod1 = new Metod1();
        Metod2 metod2 = new Metod2();
        Thread thread2 = new Thread(metod2);
        Thread thread1 = new Thread(metod1);

        thread2.start();
        thread1.start();
          System.out.println(thread1.getName());
          System.out.println(thread2.getName());

    }

}

