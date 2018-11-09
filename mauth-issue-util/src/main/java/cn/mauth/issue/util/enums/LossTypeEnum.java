package cn.mauth.issue.util.enums;

public enum LossTypeEnum {

	SECRET(1, "可以折损"), SECRET_WHITE(2, "不允许折损");

	private Integer code;

	private String desc;

	private LossTypeEnum(Integer code, String desc) {
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
