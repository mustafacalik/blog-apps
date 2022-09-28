package tr.com.calik.app.threaddump;

public class TreadDeadLock {

    public static void main(String[] args) throws InterruptedException {
        String object1 = "Object1";
        String object2 = "Object2";

        Thread thread1 = new Thread(new ExampleThread(object1, object2),"Thread 1");
        Thread thread2 = new Thread(new ExampleThread(object2, object1),"Thread 2");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("Thread 3 ...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
