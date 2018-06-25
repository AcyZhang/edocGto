package com.edocgorty;

/**
 * Created by AcY on 2018/6/19.
 */
public class synchronizedTest {
    int j=1;
    public synchronized void inc()
    {
        j++;
        System.out.println(Thread.currentThread().getName()+"答案是:"+j);
    }
    class t1 implements Runnable{
        public void run()
        {
            inc();
        }
    }
    public synchronized  void inc1(){
        j--;
        System.out.println(Thread.currentThread().getName()+"hhhuua"+j);
    }
    class t2 implements Runnable{
        public void run() {
            inc1();
        }
    }
    public static void main(String[] args) {
        synchronizedTest s=new synchronizedTest();
        t1 t1=s.new t1();
        t2 t2=s.new t2();
        for (int i=0;i<2;i++){
            Thread thread=new Thread(t1);
            thread.start();
            Thread thread1=new Thread(t2);
            thread1.start();
        }
    }
}
