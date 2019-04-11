package cn.withmes.ct.forum.topic.api.enums;

import cn.withmes.ct.forum.base.common.config.base.enums.ResultEnum;

/**
 * @Description:@Description 执行结果code枚举
 * 	  <p>0: 执行成功 ,
 * 	  <p>-1: 执行失败 ,
 * 	  <p>1000到1159之内为系统错误
 * 	  <p>1200以上为业务错误
 * 	  <topic> 400100-402000</>
 * @param:
 * @return:
 * @auther: liming
 * @date: 2018/5/19 11:10
 */
public enum TopicResultCode implements ResultEnum<Integer>{
	/**
	 * 400100:
	 */
	MEMBER_USER_NAME_IS_EMPTY(400100, "用户名不能为空"),

	/**
	 * 0:执行成功
	 */
	END(402000, "用户名不能为空");



	private Integer code;
	private String desc;

	TopicResultCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	
	/**
	 * 根据code值换取中文提示信息
	 * @param code 错误码
	 * @return
	 */
	public static String getDescByCode(String code){
		TopicResultCode codeEnum = TopicResultCode.valueOf(code);
		String rtnStr = null;
		if(codeEnum != null){
			rtnStr = codeEnum.getDesc();
		}
		return rtnStr;
	}

	@Override
	public Integer getCode() {
		return code;
	}


	@Override
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
