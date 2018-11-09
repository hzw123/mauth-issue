package cn.mauth.issue.util.enums;

public enum PayStatusEnum {

	CREATE(0, "创建"), SUCCESS(2, "支付成功"), FAIL(3, "支付失败"), UNAFFIRM(9, "异常");

	private Integer code;

	private String desc;

	private PayStatusEnum(Integer code, String desc) {
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
