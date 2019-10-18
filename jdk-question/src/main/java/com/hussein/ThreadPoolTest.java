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
     * 当调用 execute() 方法添加一个任务时，线程池会做如下判断：
     * a. 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
     * b. 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列。
     * c. 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建线程运行这个任务；
     * d. 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会抛出异常，告诉调用者“我不能再接受任务了”。
     * e.当一个线程完成任务时，它会从队列中取下一个任务来执行。
     * f.当一个线程无事可做，超过一定的时间（keepAliveTime）时，线程池会判断，如果当前运行的线程数大于 corePoolSize，那么这个线程就被停掉。所以线程池的所有任务完成后，它最终会收缩到 corePoolSize 的大小。
     */
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
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
}
