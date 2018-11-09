package cn.mauth.issue.util.enums;

public enum TradeStatusEnum {

	SUCCESS(1, "成功"), FAIL(2, "失败"), UNCONFIRM(3, "未确认");

	private Integer code;

	private String desc;

	private TradeStatusEnum(Integer code, String desc) {
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
