package cn.mauth.issue.util.enums;

public enum RepeatTypeEnum {

	YES(1, "补充"), NO(2, "未补充");

	private Integer code;

	private String desc;

	private RepeatTypeEnum(Integer code, String desc) {
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
