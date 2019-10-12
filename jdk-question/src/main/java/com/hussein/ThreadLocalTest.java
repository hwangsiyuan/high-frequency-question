package com.hussein;

import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ThreadLocal</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/12 11:48 AM
 */
public class ThreadLocalTest {

    private ThreadLocal<Integer> counter = new ThreadLocal<>();

    public static void main(String[] args) {
        new ThreadLocalTest().testThreadLocal();
    }

    /**
     * Thread 对象中存了一个ThreadLocalMap  这个Map类似于HashMap 在占用了0.75容量时扩容为原来的两倍
     * 所以对于不同的线程，每次获取副本值时，别的线程并不能获取到当前线程的副本值，形成了副本的隔离，互不干扰。
     * 如果有多个TheadLocal 时存储时hash是递增的
     * ThreadLocal.get后尽量调用remove方法，清除对应的副本数据
     * 该对象的Entry[]中 key为ThreadLocal是WeakRefrence，Value是线程的副本强引用，在发生GC时Key被回收而Value与entry无法被回收导致内存泄漏
     */
    @SuppressWarnings("all")
    private void testThreadLocal() {
        Thread thread1 = new Thread(() -> {
            setCount(1);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer count = counter.get();
            counter.remove();
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }, "thread-1");
        thread1.start();
        Thread thread2 = new Thread(() -> {
            setCount(2);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer count = counter.get();
            counter.remove();
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }, "thread-2");
        thread2.start();

    }

    private void setCount(int i) {
        counter.set(i);
    }
}
