/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年04月02日
 */
package cn.withmes.ct.forum.base;

import cn.withmes.forum.api.captcha.GifCaptcha;
import org.apache.commons.lang3.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

/**
 * ClassName: Test
 *
 * @author leegoo
 * @Description:
 * @date 2019年04月02日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class Test001 {

    @Test
    public void sss() throws Exception {
        for (int i = 0; i < 5; i++) {
            GifCaptcha gifCaptcha = new GifCaptcha();
            System.out.println(gifCaptcha.text());
            gifCaptcha.out(new FileOutputStream(new File("E:/Java/aa" + i + ".gif")));
        }
    }

}
