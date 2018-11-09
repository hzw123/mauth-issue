package cn.mauth.issue.util.enums;

public enum CarrierTypeEnum {

	MOBILE(1, "移动"), TELECOM(2, "电信"), UNICOM(3, "联通");

	private Integer code;

	private String desc;

	private CarrierTypeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	// 获取desc
	public static String getDesc(Integer code) {
		for (CarrierTypeEnum em : CarrierTypeEnum.values()) {
			if (em.getCode().equals(code)) {
				return em.getDesc();
			}
		}
		return "";
	}

	// 获取code
	public static Integer getCode(String desc) {
		for (CarrierTypeEnum em : CarrierTypeEnum.values()) {
			if (em.getDesc().equals(desc)) {
				return em.getCode();
			}
		}
		return 0;
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
