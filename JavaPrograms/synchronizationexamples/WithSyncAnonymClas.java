package synchronizationexamples;

public class WithSyncAnonymClas {
    public static void main(String[] args) {
        final Table3 table = new Table3();

        Thread th1 = new Thread() {
            @Override
            public void run() {
                table.printTable(5);
            }
        };

        Thread th2 = new Thread() {
            @Override
            public void run() {
                table.printTable(100);
            }
        };

        th1.start();
        th2.start();
    }
}

class Table3 {
    synchronized void printTable(int n) {
        for(int i = 1; i <= 6; i++) {
            System.out.println(n*i);
            
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
