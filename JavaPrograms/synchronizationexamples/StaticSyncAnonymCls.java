package synchronizationexamples;

public class StaticSyncAnonymCls {
    public static void main(String[] args) {
        
        Thread t1 = new Thread() {
            @Override
            public void run() {
                Table5.printTbl(4);
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Table5.printTbl(5);
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                Table5.printTbl(6);
            }
        };

        Thread t4 = new Thread() {
            @Override
            public void run() {
                Table5.printTbl(7);
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Table5 {
    synchronized static void printTbl(int n) {
        System.out.println("For n: " + n);

        for(int i = 1; i <= 8; i++) {
            System.out.println(n*i);
        }

        try {
            Thread.sleep(700);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
