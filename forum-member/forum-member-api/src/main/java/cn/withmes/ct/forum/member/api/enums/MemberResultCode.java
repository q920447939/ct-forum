package cn.withmes.ct.forum.member.api.enums;

import cn.withmes.ct.forum.base.common.config.base.enums.ResultEnum;

/**
 * @Description:@Description 执行结果code枚举
 * 	  <p>0: 执行成功 ,
 * 	  <p>-1: 执行失败 ,
 * 	  <p>1000到1159之内为系统错误
 * 	  <p>1200以上为业务错误
 * 	  <member> 400000-40100</>
 * @param:
 * @return:
 * @auther: liming
 * @date: 2018/5/19 11:10
 */
public enum MemberResultCode implements ResultEnum<Integer>{
	/**
	 * 400000:用户名不能为空
	 */
	MEMBER_USER_NAME_IS_EMPTY(400000, "用户名不能为空"),
	/**
	 * 400001:用户名不能为中文
	 */
	MEMBER_USER_NAME_CONTAIN_CHINESE(400001, "用户名不能为中文"),

	/**
	 * 400002:密码不能为中文
	 */
	MEMBER_PASS_WORD_CONTAIN_CHINESE(400002, "密码不能为中文"),

	/**
	 * 400003:两次输入密码不相等
	 */
	PASS_WORD_TWIN_NOT_EQUAL(400002, "两次输入密码不相等"),

	/**
	 * 400004:用户名已存在
	 */
	MEMBER_USER_NAME_EXISTS(400004, "用户名已存在"),
	/**
	 * 400005:查无用户
	 */
	MEMBER_USER_NO_EXISTS(400005, "查无用户"),
	/**
	 * 400006:账号或密码错误
	 */
	MEMBER_USER_OR_PASSWORD_ERROR(400006, "账号或密码错误"),
	/**
	 * 0:执行成功
	 */
	END(40100, "用户名不能为空");


   
	private Integer code;
	private String desc;

	MemberResultCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	
	/**
	 * 根据code值换取中文提示信息
	 * @param code 错误码
	 * @return
	 */
	public static String getDescByCode(String code){
		MemberResultCode codeEnum = MemberResultCode.valueOf(code);
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
