package io.github.wdpm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间通信： 交替打印奇偶数
 *
 * @author evan
 * @date 2020/5/7
 * @refer https://github.com/crossoverJie/JCSprout/blob/master/src/main/java/com/crossoverjie/actual/TwoThread.java
 */
public class TwoThread {

    private int start = 1;//计数器

    private volatile boolean flag = false;//是否可以执行的标记

    private final static Lock LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        TwoThread twoThread = new TwoThread();

        Thread t1 = new Thread(new OddNumber(twoThread));
        t1.setName("t1");

        Thread t2 = new Thread(new EvenNumber(twoThread));
        t2.setName("t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    /**
     * 偶数线程
     */
    public static class EvenNumber implements Runnable {

        private TwoThread thread;

        public EvenNumber(TwoThread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            while (thread.start <= 100) {
                if (thread.flag) {
                    LOCK.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + "-->" + thread.start);
                        thread.start++;
                        thread.flag = false;
                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        }
    }

    /**
     * 奇数线程
     */
    public static class OddNumber implements Runnable {

        private TwoThread thread;

        public OddNumber(TwoThread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            while (thread.start <= 100) {
                if (!thread.flag) {
                    LOCK.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + "-->" + thread.start);
                        thread.start++;
                        thread.flag = true;
                    } finally {
                        LOCK.unlock();
                    }
                }
            }
        }
    }
}