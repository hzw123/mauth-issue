package cn.mauth.issue.boss.bean.qo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mauth
 * @since 2018-01-06
 */
public class MobileInfoQO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 号码片段
	 */
	private String mobilePrefix;
	/**
	 * 省份代码
	 */
	private String provinceCode;
	/**
	 * 市代码
	 */
	private String cityCode;
	/**
	 * 区号
	 */
	private String areaCode;
	/**
	 * 省份
	 */
	private String provinceName;
	/**
	 * 市
	 */
	private String cityName;
	/**
	 * 运营商名称
	 */
	private String carrierName;
	/**
	 * 运营商类型：1移动，2 电信，3联通
	 */
	private Integer carrierType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobilePrefix() {
		return mobilePrefix;
	}

	public void setMobilePrefix(String mobilePrefix) {
		this.mobilePrefix = mobilePrefix;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Integer getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(Integer carrierType) {
		this.carrierType = carrierType;
	}
}
