/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月26日
 */
package cn.withmes.ct.forum.topic.base.enmus;

import cn.withmes.ct.forum.base.common.config.base.enums.ResultEnum;

/**
 * ClassName: ResultCode
 * @Description:
 * @author leegoo
 * @date 2019年03月26日
 */
public class ResultCode implements ResultEnum<Integer> {
    private Integer code;
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code值换取中文提示信息
     * @param code 错误码
     * @return
     */
    public static String getDescByCode(String code){
        cn.withmes.ct.forum.base.common.config.base.enums.ResultCode codeEnum = cn.withmes.ct.forum.base.common.config.base.enums.ResultCode.valueOf(code);
        String rtnStr = null;
        if(codeEnum != null){
            rtnStr = codeEnum.getDesc();
        }
        return rtnStr;
    }


    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    
}
