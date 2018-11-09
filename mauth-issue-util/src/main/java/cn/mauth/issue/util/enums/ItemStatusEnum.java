package cn.mauth.issue.util.enums;

public enum ItemStatusEnum {

	INIT(1, "初始化"), UP(2, "上架"), DOWN(3, "下架");

	private Integer code;

	private String desc;

	private ItemStatusEnum(Integer code, String desc) {
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
