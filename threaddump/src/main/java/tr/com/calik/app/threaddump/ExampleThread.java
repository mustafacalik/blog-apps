package tr.com.calik.app.threaddump;

public class ExampleThread implements Runnable{
    private Object object1;
    private Object object2;

    public ExampleThread(Object o1, Object o2){
        this.object1 =o1;
        this.object2 =o2;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        print(name + " START ");
        print(name + " begin to lock --> " + object1);
        synchronized (object1) {
            print(name + " locked --> " + object1);
            sleep();
            print(name + " begin to lock --> " + object2);
            synchronized (object2) {
                print(name + " locked --> " + object2);
            }
            print(name + " lock relased --> " + object2);
        }
        print(name + " lock released --> " + object1);
        print(name + " FINISH ");
    }
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    private void print(String message){
        System.out.println(message);
    }
}
