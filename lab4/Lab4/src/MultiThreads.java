class MyTask implements Runnable {
    @Override
    public void run() {
        for (int i =0 ; i < 10; i++) {
            System.out.println("My Task: " + i);
        }
    }
}

public class MultiThreads {
    // main method represents main thread
    public static void main(String[] args) {
        System.out.println("Application Started");

        Thread mt = new Thread(new MyTask());
        mt.start();  // -> internally call the run method

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("Application Finished");
    }
}
