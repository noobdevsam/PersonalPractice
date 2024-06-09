package synchronizationexamples;

public class SyncBlockAnonymCls {
    public static void main(String[] args) {
        final Sender snd = new Sender(); // a obj to share
        
        Thread th1 = new Thread() {
            @Override
            public void run() {
                synchronized (snd) {
                    snd.sendMsg("Hola");
                }
            }
        };

        Thread th2 = new Thread() {
            @Override
            public void run() {

                // only one thread sends message at a time
                synchronized(snd) {

                    // synchornizing the object
                    snd.sendMsg("Welcome to Java Programming!!!");
                }
            }
        };


        // starting the threads
        th1.start();
        th2.start();

        // waiting for threads to end
        try {
            th1.join();
            th2.join();
        } catch (Exception e) {
            System.out.println("Interrupted!!!");
        }
    }
}

// executes sends
class Sender {
    public void sendMsg(String msg) {
        System.out.println("\nSending message: " + msg);

        try {
            Thread.sleep(700);
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("\n" + msg + " [Sent]");
    }
}

