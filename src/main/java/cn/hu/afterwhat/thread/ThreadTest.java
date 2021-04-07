package cn.hu.afterwhat.thread;

import lombok.SneakyThrows;

public class ThreadTest {

    public static int auth = 0;
    public static Object auth1 = 0;
    public static byte[] lock = new byte[0];



    public static void main(String[] args) {
        /*try {
            TimeInterval interval = new TimeInterval();
            Thread thread = test2();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();

            System.err.println("main().TimeInterval = " + interval.interval());
        } catch (InterruptedException e) {
            System.err.println("main().Thread.sleep() = " + e.getMessage());
        }*/


        Thread thread = test3();
        Thread thread1 = test3();
        thread.start();
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
//        thread1.interrupt();


    }


    /**
     * 使用的isInterrupted() 和 interrupt()方法终止一个线程
     * 异常终止
     *
     * @return
     */
    public static Thread test1() {
        Thread thread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                super.run();

                for (int i = 0; i < 1000; i++) {
                    if (this.isInterrupted()) {
                        throw new InterruptedException("检测线程中断状态");
                    }
                    Thread.sleep(100);
                    System.out.println("i = " + i);
                }

            }
        };


        return thread;
    }

    /**
     * 通过interrupt() 配合sleep()方法终止一个线程
     * @return
     */
    public static Thread test2() {
        Thread thread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                super.run();

                for (int i = 0; i < 1000; i++) {
                    Thread.sleep(100);
                    System.out.println("i = " + i);
                }

            }
        };
        return thread;
    }

    public static Thread test3() {
        Thread thread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                super.run();

                int i = 0;
                while (true) {

                    synchronized (lock){
                        lock.wait();
                        i ++;
                        System.out.println(i);
                        lock.notifyAll();
                    }

                    if (i > 1000) {
                        return;
                    }
                }

            }
        };
        return thread;
    }
}
