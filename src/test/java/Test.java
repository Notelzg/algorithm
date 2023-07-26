import java.util.concurrent.ArrayBlockingQueue;

class Base {
  public static String c = "c";
  static {
    System.out.println("Base");
  }
  public Base() {
    System.out.println(this.getClass().getSimpleName());
    this.g();
  }

  public void f() {
    System.out.println("base f");
  }

  public void g() {
    System.out.println("base g");
  }
}
   class Child extends  Base {
     static {
       System.out.println("Static ---- Child");
     }

    public void f() {
      System.out.println("Child f");
    }

    public void g() {
      System.out.println("Child g");
    }
  }


public class Test {
  public static void main(String[] args) {
    ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
    for (int i = 0; i <10 ; i++) {
      int finalI = i;
      new Thread(()->{
        try {
          System.out.println(Thread.currentThread().getName() + ", start put " );
          queue.put(finalI);
          System.out.println(Thread.currentThread().getName() + ", finish put: " + finalI);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }).start();
    }

    new Thread(()->{
      try {
        System.out.println(Thread.currentThread().getName() + ", start take " );
        Integer f = queue.take();
        System.out.println(Thread.currentThread().getName() + ", finish take: " + f);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();


  }
}
