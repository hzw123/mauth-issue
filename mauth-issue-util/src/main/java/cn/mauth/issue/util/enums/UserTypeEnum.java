package cn.mauth.issue.util.enums;

public enum UserTypeEnum {

	USER(1, "内部用户"), MERCHANTS(2, "下游商户");

	private Integer code;

	private String desc;

	private UserTypeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
