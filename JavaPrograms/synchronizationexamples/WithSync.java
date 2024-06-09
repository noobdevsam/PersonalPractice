package synchronizationexamples;

class Table2 {
    synchronized void printTable(int n) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(n*i);
            
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MThreadA extends Thread{
    Table2 t;

    MThreadA(Table2 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}

class MThreadB extends Thread {
    Table2 t;

    MThreadB(Table2 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(100);
    }
}

public class WithSync {
    public static void main(String[] args) {
        Table2 table = new Table2();
        MThreadA mtA = new MThreadA(table);
        MThreadB mtB = new MThreadB(table);

        mtA.start();
        mtB.start();
        // threads execute randomly
    }
}