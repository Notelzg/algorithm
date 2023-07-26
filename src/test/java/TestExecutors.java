import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class TestExecutors {
  @Test
  public void test() throws InterruptedException {
    ThreadPoolExecutor executor =
            new ThreadPoolExecutor(5, 10,
                    1000L, TimeUnit.MILLISECONDS,
                    new SynchronousQueue<>());
    for (int i = 0; i < 10; i++) {
      executor.execute(() -> System.out.println(Thread.currentThread().getName()));
    }
    System.out.println(executor.toString());
    Thread.sleep(2000);
    System.out.println(executor.toString());
    executor.allowCoreThreadTimeOut(true);
    ;
    Thread.sleep(2000);
    System.out.println(executor.toString());
  }

  @Test
  public void testPoll() throws InterruptedException {
    ArrayBlockingQueue<Integer> a = new ArrayBlockingQueue<>(10);
    long start = System.currentTimeMillis();
    Integer e = a.poll(0, TimeUnit.MILLISECONDS);
    long cost = System.currentTimeMillis() - start;
    assert cost == 0;
    System.out.println("cost :" + cost + ", e " + e);
  }

  @Test
  public void testPoll10() throws InterruptedException {
    ArrayBlockingQueue<Integer> a = new ArrayBlockingQueue<>(10);
    long start = System.currentTimeMillis();
    Integer e = a.poll(1000, TimeUnit.MILLISECONDS);
    long cost = System.currentTimeMillis() - start;
    assert cost >= 1000;
    System.out.println("cost :" + cost + ", e " + e);
  }
}
