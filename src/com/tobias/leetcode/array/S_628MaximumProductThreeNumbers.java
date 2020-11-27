package com.tobias.leetcode.array;






import sun.reflect.Reflection;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 *Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: 6
 *
 *
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: 24
 *
 *
 * Note:
 *
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 */
public class S_628MaximumProductThreeNumbers {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();
        ThreadLocalRandom.current();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        int i = current.nextInt();
        int i1 = current.nextInt(10000);
        int i2 = current.nextInt(10000);
        Class<?> callerClass = Reflection.getCallerClass(1);
        System.out.println(callerClass);
        System.out.println(callerClass.getClassLoader());
        System.out.println(Reflection.getClassAccessFlags(S_628MaximumProductThreeNumbers.class));


        Callable<Boolean> callableA = () -> {
            try {
                System.out.println("threadA try lockA");
                lockA.tryLock(1, TimeUnit.MINUTES);
                System.out.println("threadA lockA lock");
                Thread.sleep(5000);
                try {
                    System.out.println("threadA try lockB");
                    lockB.tryLock(1, TimeUnit.MINUTES);
                } finally {
                    lockB.unlock();
                    System.out.println("threadA lockB unlock");
                }
                System.out.println("threadA lockB lock end");
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
                System.out.println("threadA lockA unlock");
            }
            return false;
        };
        Callable<Boolean> callableB = () -> {
            LongAdder longAdder = new LongAdder();
            try {
                System.out.println("threadB try lockB");
                lockB.lock();
                System.out.println("threadB lockB lock");
                Thread.sleep(1000);
                boolean tryLockA = false;
                try {
                    while (longAdder.intValue() < 3 && !tryLockA) {
                        System.out.println("threadB try lockA");
                        tryLockA = lockA.tryLock(1000, TimeUnit.MILLISECONDS);
                        longAdder.increment();
                        System.out.println("threadB try lockA result = " + tryLockA);
                    }
                    if (!tryLockA) {
                        lockB.unlock();
                        System.out.println("threadB lockB unlock");
                        return false;
                    }
                    System.out.println("threadB lockA lock");
                    System.out.println("threadB end");
                    return true;
                } finally {
                    if (lockA.isLocked() && tryLockA){
                        System.out.println("threadB lockA unlock normally");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lockB.isLocked()) {
                    lockB.unlock();
                    System.out.println("threadB lockB unlock");
                }
            }
            return false;
        };

        Future<?> future1 = executorService.submit(() -> {
            new LongAdder();
            try {
                executorService.submit(callableA).get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Future<?> future2 = executorService.submit(() -> {
            LongAdder longAdder = new LongAdder();
            boolean result = false;
            try {
                while (longAdder.intValue() < 5 && !result) {
                    longAdder.increment();
                    System.out.println("enter while");
                    result = executorService.submit(callableB).get();
                    System.out.println("submitB result : " + result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        future1.get();
        future2.get();
        System.out.println("get future done");
        System.out.println("shutdown executor");
        executorService.shutdown();
    }
}
