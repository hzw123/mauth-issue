package cn.mauth.issue.util.enums;

public enum FlowModeEnum {

	CURRENT(1, "立即生效"), NEXT(2, "下月生效");

	private Integer code;

	private String desc;

	private FlowModeEnum(Integer code, String desc) {
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
