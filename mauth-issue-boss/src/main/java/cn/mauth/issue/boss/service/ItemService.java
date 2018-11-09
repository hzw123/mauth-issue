package cn.mauth.issue.boss.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.ItemQO;
import cn.mauth.issue.boss.bean.vo.ItemVO;
import cn.mauth.issue.common.dao.AreaInfoDao;
import cn.mauth.issue.common.dao.ItemDao;
import cn.mauth.issue.common.entity.Item;
import cn.mauth.issue.common.example.ItemExample;
import cn.mauth.issue.common.example.ItemExample.Criteria;
import cn.mauth.issue.util.BigDecimalUtils;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.util.enums.CarrierTypeEnum;
import cn.mauth.issue.util.enums.FlowPackageTypeEnum;
import cn.mauth.issue.util.enums.FlowScopeEnum;
import cn.mauth.issue.util.enums.FlowStreamTypeEnum;
import cn.mauth.issue.util.enums.ItemStatusEnum;
import cn.mauth.issue.util.enums.ItemTypeEnum;
import cn.mauth.issue.util.exception.BaseException;
import com.xiaoleilu.hutool.util.ReUtil;
import org.springframework.util.StringUtils;

/**
 * 商品管理
 *
 * @author mauth
 * @since 2017-12-19
 */
@Component
public class ItemService {

	@Autowired
	private ItemDao dao;
	@Autowired
	private AreaInfoDao areaInfoDao;

	public Page<ItemVO> listForPage(int pageCurrent, int pageSize, ItemQO qo) {
		ItemExample example = new ItemExample();
		Criteria c = example.createCriteria();
		if(!StringUtils.isEmpty(qo.getItemNo())){
			c.andItemNoLike(qo.getItemNo());
		}
		if(!StringUtils.isEmpty(qo.getItemName())){
			c.andItemNameLike(qo.getItemName());
		}

		example.setOrderByClause(" id desc ");
		Page<Item> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, ItemVO.class);
	}

	public int save(ItemQO qo) {
		Item record = new Item();
		BeanUtils.copyProperties(qo, record);
		// 商品编码=商品类型+运营商类型+销售地区+面值
		record.setItemNo(getItemNo(qo));
		record.setItemName(areaInfoDao.getByProvinceCode(qo.getSalesArea()).getProvinceName() + CarrierTypeEnum.getDesc(qo.getCarrierType()) + qo.getFacePrice() + ItemTypeEnum.getDesc(qo.getItemType()) + FlowScopeEnum.getDesc(qo.getFlowScope()) + FlowPackageTypeEnum.getDesc(qo.getFlowPackageType()) + FlowStreamTypeEnum.getDesc(qo.getFlowStreamType()));
		record.setCostPrice(BigDecimalUtils.integerMultiply(qo.getCostPrice()));
		record.setSalesPrice1(BigDecimalUtils.integerMultiply(qo.getSalesPrice1()));
		record.setSalesPrice2(BigDecimalUtils.integerMultiply(qo.getSalesPrice2()));
		record.setSalesPrice3(BigDecimalUtils.integerMultiply(qo.getSalesPrice3()));
		if (record.getSalesPrice1() < record.getSalesPrice2()) {
			throw new BaseException("销售价1不能低于销售价2");
		}
		if (record.getSalesPrice2() < record.getSalesPrice3()) {
			throw new BaseException("销售价2不能低于销售价3");
		}
		if (record.getSalesPrice3() < record.getCostPrice()) {
			throw new BaseException("销售价3不能低于成本价");
		}

		record.setItemStatus(ItemStatusEnum.INIT.getCode());
		return dao.save(record);
	}

	private String getItemNo(ItemQO qo) {
		if (qo.getFlowScope() == null) {
			qo.setFlowScope(0);
		}
		if (qo.getFlowPackageType() == null) {
			qo.setFlowPackageType(0);
		}
		if (qo.getFlowStreamType() == null) {
			qo.setFlowStreamType(0);
		}
		return qo.getItemType().toString() + qo.getCarrierType().toString() + qo.getSalesArea().toString() + ReUtil.getFirstNumber(qo.getFacePrice()).toString() + qo.getFlowScope().toString() + qo.getFlowPackageType().toString() + qo.getFlowStreamType().toString();
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public ItemVO getById(Long id) {
		ItemVO vo = new ItemVO();
		Item record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(ItemQO qo) {
		Item record = new Item();
		// 商品编码=商品类型+运营商类型+销售地区+面值
		record.setId(qo.getId());
		record.setFacePrice(qo.getFacePrice());
		record.setCostPrice(BigDecimalUtils.integerMultiply(qo.getCostPrice()));
		record.setSalesPrice1(BigDecimalUtils.integerMultiply(qo.getSalesPrice1()));
		record.setSalesPrice2(BigDecimalUtils.integerMultiply(qo.getSalesPrice2()));
		record.setSalesPrice3(BigDecimalUtils.integerMultiply(qo.getSalesPrice3()));
		if (record.getSalesPrice1() < record.getSalesPrice2()) {
			throw new BaseException("销售价1不能低于销售价2");
		}
		if (record.getSalesPrice2() < record.getSalesPrice3()) {
			throw new BaseException("销售价2不能低于销售价3");
		}
		if (record.getSalesPrice3() < record.getCostPrice()) {
			throw new BaseException("销售价3不能低于成本价");
		}

		record.setItemStatus(qo.getItemStatus());
		return dao.updateById(record);
	}

}
