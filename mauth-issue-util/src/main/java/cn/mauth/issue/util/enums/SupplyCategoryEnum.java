package cn.mauth.issue.util.enums;

public enum SupplyCategoryEnum {

	RECHARGE(1, "充值供货商"), EXCHANGE(2, "兑换供货商");

	private Integer code;

	private String desc;

	private SupplyCategoryEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	// 获取desc
	public static String getDesc(Integer code) {
		for (SupplyCategoryEnum em : SupplyCategoryEnum.values()) {
			if (em.getCode().equals(code)) {
				return em.getDesc();
			}
		}
		return "";
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
