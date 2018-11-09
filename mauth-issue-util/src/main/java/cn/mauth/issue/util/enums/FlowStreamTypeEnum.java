package cn.mauth.issue.util.enums;

/**
 * 通道类型
 */
public enum FlowStreamTypeEnum {

	WHOLE(1, "全国"), PROVINCE(2, "分省");

	private Integer code;

	private String desc;

	private FlowStreamTypeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	// 获取desc
	public static String getDesc(Integer code) {
		for (FlowStreamTypeEnum em : FlowStreamTypeEnum.values()) {
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
