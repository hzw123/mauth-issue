package cn.mauth.issue.boss.bean.vo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mauth
 * @since 2017-12-30
 */
public class AreaInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 省编号
	 */
	private String provinceCode;
	/**
	 * 市编号
	 */
	private String cityCode;
	/**
	 * 区号
	 */
	private String areaCode;
	/**
	 * 省名称
	 */
	private String provinceName;
	/**
	 * 市名称
	 */
	private String cityName;
	/**
	 * 分类：1.省 2 市
	 */
	private Integer areaType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}
}
