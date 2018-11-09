package cn.mauth.issue.util.enums;

public enum ItemCategoryEnum {

	RECHARGE(1, "充值"), EXCHANGE(2, "兑换");

	private Integer code;

	private String desc;

	private ItemCategoryEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	// 获取desc
	public static String getDesc(Integer code) {
		for (ItemCategoryEnum em : ItemCategoryEnum.values()) {
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
