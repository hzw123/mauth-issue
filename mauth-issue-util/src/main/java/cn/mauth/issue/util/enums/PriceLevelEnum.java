package cn.mauth.issue.util.enums;

public enum PriceLevelEnum {

	ONE(1, "销售价1"), TWO(2, "销售价2"), THREE(3, "销售价3");

	private Integer code;

	private String desc;

	private PriceLevelEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	// 获取desc
	public static String getDesc(Integer code) {
		for (PriceLevelEnum em : PriceLevelEnum.values()) {
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
