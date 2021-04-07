package cn.hu.afterwhat.thread;

import cn.hutool.core.date.TimeInterval;
import lombok.SneakyThrows;

public class ThreadTest {


    public static void main(String[] args) {
        try {
            TimeInterval interval = new TimeInterval();
            Thread thread = test2();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();

            System.err.println("main().TimeInterval = " + interval.interval());
        } catch (InterruptedException e) {
            System.err.println("main().Thread.sleep() = " + e.getMessage());
        }


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
}
