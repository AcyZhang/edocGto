package com.edocgorty;

/**
 * Created by AcY on 2018/5/17.
 */
public class cssTest {
    //    public int f()
//    {
//        static int i = 0;
//        i++;
//        return i;
//    }
    public static void splitString(String src, int len) {
        int byteNum = 0;
        if (null == src) {
            System.out.println("The source String is null!");
            return;
        }
        byteNum = src.length();
        byte bt[] = src.getBytes(); // 将String转换成byte字节数组
        if (len > byteNum) {
            len = byteNum;
        }
        // 判断是否出现了截半，截半的话字节对于的ASC码是小于0的值
        if (bt[len] < 0) {
            String subStrx = new String(bt, 0, --len);
            System.out.println("subStrx==" + subStrx);
        } else {
            String subStrx = new String(bt, 0, len);
            System.out.println("subStrx==" + subStrx);
        }
    }

    public static void main(String[] args) {
//        int i = 0;
//        for (f('A'); f('B') && (i < 2); f('C'))
//        {
//            i++;
//            f('D');
//        }
//    }
//       try {
//           return;
//       }finally {
//           System.out.println("ssss");
//       }
//        class A{
//            public int i=3;
//        }
//Object o=(Object) new A();
//        A a=(A) o;
//        System.out.println("i="+a.i);
//        String a = "hello";
//        change(a);
//        System.out.println(a);
//    }
//    public static void change(String name)
//    {
//        name="world";
//        static boolean f(char c)
//        {
//            System.out.print(c);
//            return true;

//            cssTest test = new cssTest();
//            test.f();
//            int j = test.f();
//            System.out.println(j);
        String srcStr1 = "我ABC";
        String srcStr2 = "我ABC汉DEF";

        splitString(srcStr1, 4);
        splitString(srcStr2, 6);
    }
}
