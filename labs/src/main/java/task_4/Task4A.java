package task_4;
/*a)
Use a CountDownLatch to wait for a set of threads
to complete before continuing execution in the main thread.
 */

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Task4A {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    static Random rand = new Random(123);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("I love pizza 1");
            sleep();
            System.out.println("I love pizza 1 DONE");
            countDownLatch.countDown();
        });

        Thread t2 = new Thread(() -> {
            System.out.println("I love pizza 2");
            sleep();
            System.out.println("I love pizza 2 DONE");
            countDownLatch.countDown();
        });

        Thread t3 = new Thread(() -> {
            System.out.println("I love pizza 3");
            sleep();
            System.out.println("I love pizza 3 DONE");
            countDownLatch.countDown();
        });

        t1.start();
        t2.start();
        t3.start();

        countDownLatch.await();
        System.out.println("END");
    }

    static void sleep() {
        try {
            Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
