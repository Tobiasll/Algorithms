package rudiments;

import com.tobias.rudiment.array.MyArray;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class ArrayGraphTraverse {

  @Test
  public void test1() {
    MyArray<Integer> array = new MyArray<>();

    System.out.println(array.getCapacityLength());
    System.out.println(array.isEmpty());
    System.out.println(array);
    array.addLast(1);
    array.addLast(3);
    array.addLast(4);
    array.addFirst(2);
    array.insert(3, 88);

    System.out.println(array.removeIndex(3));
    System.out.println(array.removeFirst());
    System.out.println(array.removeLast());
    System.out.println(array.set(1, 22));
    array.removeElement(1);
    System.out.println(array);
    System.out.println(array.getSize());
    System.out.println(array.get(0));


  }

  @Test
  public void test2() {
    int n = -5;
    String result = "";
    while (n != 0) {
      result += n % 2;
      n = n >> 1;
    }
    System.out.println(result);
  }

  @Test
  public void test3() {
    ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
    ThreadGroup group = Thread.currentThread().getThreadGroup().getParent();
    final Thread[] slackList = new Thread[group.activeCount() * 2];
    final int actualSize = group.enumerate(slackList);
    final Thread[] result = new Thread[actualSize];
    System.arraycopy(slackList, 0, result, 0, actualSize);

  }


  @Test
  public void test4() throws InterruptedException {

    ClhSpinLock clhSpinLock = new ClhSpinLock();

    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + " try lock");
        clhSpinLock.lock();
        System.out.println(Thread.currentThread().getName() + " lock");
        clhSpinLock.unlock();
        System.out.println(Thread.currentThread().getName() + " unlock");
      },"Thread:" +  i).start();
      int sleepTime = ThreadLocalRandom.current().nextInt(2000, 10000);
      try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("for each done!");
    clhSpinLock.lock();
    Thread.sleep(3000);
    clhSpinLock.unlock();
    System.out.println("thread main  clhSpinLock.unlock()");

  }

  static class ClhSpinLock {

    private final ThreadLocal<Node> prev;
    private final ThreadLocal<Node> node;
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    public ClhSpinLock() {
      this.node = ThreadLocal.withInitial(Node::new);
      this.prev = ThreadLocal.withInitial(() -> null);
    }

    public void lock() {
      final Node node = this.node.get();
      node.locked = true;
      // 一个CAS操作即可将当前线程对应的节点加入到队列中，
      // 并且同时获得了前继节点的引用，然后就是等待前继释放锁
      Node pred = this.tail.getAndSet(node);
      this.prev.set(pred);
      while (true) {
        if (!pred.locked) {
          System.out.println("enter break");
          break;// 进入自旋
        }
      }
    }

    public void unlock() {
      final Node node = this.node.get();
      node.locked = false;
      this.node.set(this.prev.get());
    }

    private static class Node {
      private volatile boolean locked;
    }
  }

  @Test
  public void test5() throws InterruptedException {
    Thread thread = new Thread(() -> {
      System.out.println("child thread begin!");
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println("enter while park thread");
        LockSupport.park(this);

      }
      System.out.println("child thread end!");
    });
    thread.start();
    Thread.sleep(1500);
    System.out.println("main thread run,un park begin!");
//    LockSupport.unpark(thread);
    thread.interrupt();
    System.out.println("un park end!");

    LockSupport.park(this);
  }

  @Test
  public void test6() throws InterruptedException {
    MutexQueue queue = new MutexQueue();
    for (int i = 0 ; i < 10; i++) {
      Thread thread = new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + " test lock ");
        queue.lock();
        System.out.println(Thread.currentThread().getName() + " test unlock ");
        queue.unlock();
        System.out.println(Thread.currentThread().getName() + " test unlock done!");
      },  "thread:" + i);
      thread.start();

    }

    Thread.sleep(10000);

  }

  static class MutexQueue {

    private final AtomicBoolean hasLock = new AtomicBoolean(false);
    private final Queue<Thread> queue = new ConcurrentLinkedQueue<>();

    public void lock() {
      Thread currentThread = Thread.currentThread();
      System.out.println(currentThread.getName() + " enter lock!");
      boolean innerHasLock = false;
      queue.add(currentThread);
      while (currentThread != queue.peek() || !hasLock.compareAndSet(false, true)) {
        System.out.println(currentThread.getName() + " enter while pack current!");
        LockSupport.park(this);
        System.out.println(currentThread.getName() + "  pack done");
        if (Thread.interrupted()) {
          innerHasLock = true;
        }
      }
      System.out.println(currentThread.getName() + "remove from queue!");
      queue.remove(currentThread);
      if (innerHasLock) {
        System.out.println(currentThread.getName() + " to interrupt");
        currentThread.interrupt();
      }
    }

    public void unlock() {
      if (queue.isEmpty()) return;
      System.out.println(queue.peek().getName() + " unlock");
      hasLock.set(true);
      LockSupport.unpark(queue.peek());

    }
  }
  
  @Test
  public void test7() {
    final int COUNT_BITS = Integer.SIZE - 3;
    final int RUNNING    = -1 << COUNT_BITS;
    final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 1));
    System.out.println(Integer.toBinaryString(-1));
    System.out.println(Integer.toBinaryString(RUNNING));
    System.out.println(COUNT_BITS);

    System.out.println(Integer.toBinaryString(ctl.get()));
  }


  private static int ctlOf(int rs, int wc) { return rs | wc; }



}
