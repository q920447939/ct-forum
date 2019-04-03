/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年04月03日
 */
package cn.withmes.ct.forum.base.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: ReUtils
 *
 * @author leegoo
 * @Description:
 * @date 2019年04月03日
 */
public class ReUtils {

    /**
     * @Description:验证字符串是否包含中文
     * @param: [str]
     * @return: boolean
     * @auther: liming
     * @date: 2019/4/3 16:54
     */
    public static boolean reContainChinese(String str) {
        String reg = "[\u2E80-\u9FFF]";
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(str);
        return mat.find();
    }
}
