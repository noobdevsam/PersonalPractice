package synchronizationexamples;

public class SyncBlockSec {
    public static void main(String[] args) {
        final Sender snd = new Sender(); // a obj to share
        SenderWThreads th1 = new SenderWThreads("Hola", snd);
        SenderWThreads th2 = new SenderWThreads("Welcome to Java Programming!!!", snd);

        // starts two threads
        th1.start();
        th2.start();

        // wait for threads to end
        try {
            th1.join();
            th2.join();
        } catch (Exception e) {
            System.out.println("Interrupted!!!");
        }
    }
}

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

// Sending message using Threads
class SenderWThreads extends Thread {
    private String msg;
    Sender sender;

    SenderWThreads(String msg, Sender sender) {
        this.msg = msg;
        this.sender = sender;
    }

    @Override
    public void run() {

        // checks that only one thread send message at a time
        synchronized(sender) {
            
            // synchronizing the sender object
            sender.sendMsg(msg);
        }
    }
}
