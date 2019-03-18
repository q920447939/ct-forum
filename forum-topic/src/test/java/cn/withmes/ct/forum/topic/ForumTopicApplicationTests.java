/*
package cn.withmes.ct.forum.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumTopicApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static int getPrice(int totalValue, int amouont, int totalAmount) {
        if (totalAmount == 0) {
            return 0;
        } else {
            BigDecimal returnPrice = new BigDecimal(totalValue);
            return returnPrice.multiply(new BigDecimal(amouont)).divide(new BigDecimal(totalAmount), 0, 6).intValue();
        }
    }

    public static void main(String[] args) {
        int price = getPrice(30000, 20000, 25000);
        System.out.println(price);
    }

}
*/
