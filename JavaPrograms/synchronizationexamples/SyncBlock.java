package synchronizationexamples;

public class SyncBlock {
    public static void main(String[] args) {
        Table4 table = new Table4(); // only one object to share
        MThrdC thrdC = new MThrdC(table);
        MThrdD thrdD = new MThrdD(table);

        thrdC.start();
        thrdD.start();
    }
}

class Table4 {
    void printTable(int n) {

        // synchronize only specified lines
        synchronized (this) {
            for (int i = 1; i < 7; i++) {
                System.out.println(n * i);
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MThrdC extends Thread {
    Table4 t;

    MThrdC(Table4 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(10);
    }
}

class MThrdD extends Thread {
    Table4 t;

    MThrdD(Table4 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(150);
    }
}
