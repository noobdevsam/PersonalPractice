package synchronizationexamples;

class Table {
    void printTable(int n) {
        for(int i = 1; i < 5; i++) {
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
    Table t;

    MThreadA(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}

class MThreadB extends Thread {
    Table t;

    MThreadB(Table t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(100);
    }
}

public class WithoutSync {
    public static void main(String[] args) {
        Table table = new Table();
        MThreadA mtA = new MThreadA(table);
        MThreadB mtB = new MThreadB(table);

        mtA.start();
        mtB.start();
        // because of the 'synchronized' keyword,
        // mtA, mtB has locks for each of them and
        // due to call time, mtA.start() finishes first and after that
        // mtB.start() finishes.
    }
}