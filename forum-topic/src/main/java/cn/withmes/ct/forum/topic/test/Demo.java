/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月19日
 */
package cn.withmes.ct.forum.topic.test;

/**
 * ClassName: Demo
 *
 * @author leegoo
 * @Description:
 * @date 2019年03月19日
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(lookValue(5));
    }

    public static int lookValue(int value) {
        try {
            System.out.println("value start is :" + value);
            value++;
            System.out.println("value end is :" + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return value;
        } finally {
            System.out.println("value finally start is :" + value);
            value++;
            return value;
            //System.out.println("value finally end is :" + value);
        }
    }
}
