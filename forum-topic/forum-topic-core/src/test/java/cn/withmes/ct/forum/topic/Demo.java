/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月25日
 */
package cn.withmes.ct.forum.topic;

/**
 * ClassName: Demo
 * @Description:
 * @author leegoo
 * @date 2019年03月25日
 */
public class Demo {

    private int math;

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public static void main(String[] args) {
       /* int a = 10;
        func(a);*/
        Demo d = new Demo();
        d.setMath(10);
        func(d);
        System.out.println("main:"+d.getMath());
    }

    private static void func(Demo d) {
      Object a = new Object();
        synchronized (a) {

        }


    }

    private static void func(int a ) {
        a= 20;
        System.out.println(a);
    }

}
