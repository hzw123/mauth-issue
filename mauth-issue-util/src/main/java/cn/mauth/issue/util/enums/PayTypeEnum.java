package cn.mauth.issue.util.enums;

public enum PayTypeEnum {

	BALANCE(1, "余额");

	private Integer code;

	private String desc;

	private PayTypeEnum(Integer code, String desc) {
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
