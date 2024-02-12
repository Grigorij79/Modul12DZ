public class Zad2 {
    volatile int counter = 1;
    volatile String number = "";
    volatile boolean flagReadFizzBuzz = false;
    public static void main(String args[]) {
        Zad2 clas = new Zad2();
        int max = 300;
        clas.start(max,clas);
    }
    public void start(final int max, Object clas) {

        Runnable A = () -> {
            synchronized(this) {
                while(counter<= max){
                    if(counter % 3 ==0 && counter %5 !=0) {
                        number = "fizz";
                        flagReadFizzBuzz = true;
                        counter++;
                        clas.notifyAll();
                    }else{
                        try{
                            clas.wait();
                        }catch(Exception e) {System.out.println(e);}
                    }
                }
            }
        };

        Runnable B = () -> {
            synchronized(this) {
                while(counter<= max){
                    if(counter % 5 == 0 && counter %3 !=0) {
                        flagReadFizzBuzz = true;
                        number = "buzz";
                        counter++;
                        clas.notifyAll();
                    }else{
                        try{
                            clas.wait();}catch(Exception e) {System.out.println(e);}
                    }
                }
            }
        };
        Runnable C = () -> {
            synchronized(this) {
                while(counter<= max){
                    if(counter % 3 ==0 && counter % 5 ==0) {
                        flagReadFizzBuzz = true;
                        number = "fizzbuzz";
                        counter++;
                        clas.notifyAll();
                    }else{
                        try{
                            clas.wait();
                        }catch(Exception e) {System.out.println(e);}
                    }
                }
            }
        };
        Runnable D = () -> {
            synchronized(this) {
                while(counter<= max){
                    if (flagReadFizzBuzz) {
                        System.out.println( number);
                        flagReadFizzBuzz = false;
                    }
                    if(counter % 3 !=0 && counter % 5 !=0) {
                        number = String.valueOf(counter);
                        System.out.println( number);
                        counter++;
                        clas.notifyAll();
                    }else{
                        try{
                            clas.wait();
                        }catch(Exception e) {System.out.println(e);}
                    }
                }
            }
        };

        new Thread(A).start();
        new Thread(B).start();
        new Thread(C).start();
        new Thread(D).start();

    }
}
