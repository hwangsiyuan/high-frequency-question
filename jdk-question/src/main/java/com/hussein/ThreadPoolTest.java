package com.hussein;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * <p>Title: ThreadPoolTest</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/12 2:32 PM
 */
public class ThreadPoolTest {

    /**
     * 降低系统消耗，方便管理线程，提高响应速度
     * 线程池 参数列表 核心线程数，最大线程数，超过core的线程空闲保持时间，线程工厂，拒绝策略
     */
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler rejectedExecutionHandler = new MyAbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, queue, threadFactory, rejectedExecutionHandler);
        IntStream.range(1, 100).forEach(i -> {
            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            });
        });
    }

    private static class MyAbortPolicy extends ThreadPoolExecutor.AbortPolicy {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            super.rejectedExecution(r, e);
        }
    }
}
