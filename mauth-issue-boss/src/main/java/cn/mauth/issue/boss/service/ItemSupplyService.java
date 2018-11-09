package cn.mauth.issue.boss.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.ItemSupplyQO;
import cn.mauth.issue.boss.bean.vo.ItemSupplyVO;
import cn.mauth.issue.common.dao.ItemSupplyDao;
import cn.mauth.issue.common.entity.ItemSupply;
import cn.mauth.issue.common.example.ItemSupplyExample;
import cn.mauth.issue.common.example.ItemSupplyExample.Criteria;
import cn.mauth.issue.util.BigDecimalUtils;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;

/**
 * 供应商商品管理
 *
 * @author mauth
 * @since 2017-12-19
 */
@Component
public class ItemSupplyService {

	@Autowired
	private ItemSupplyDao dao;

	public Page<ItemSupplyVO> listForPage(int pageCurrent, int pageSize, ItemSupplyQO qo) {
		ItemSupplyExample example = new ItemSupplyExample();
		Criteria c = example.createCriteria();
		if (ObjectUtil.isNotNull(qo.getItemId())) {
			c.andItemIdEqualTo(qo.getItemId());
		}
		example.setOrderByClause(" item_status asc, id desc ");
		Page<ItemSupply> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, ItemSupplyVO.class);
	}

	public int save(ItemSupplyQO qo) {
		ItemSupply record = new ItemSupply();
		BeanUtils.copyProperties(qo, record);
		record.setFacePrice(qo.getFacePrice());
		record.setCostPrice(BigDecimalUtils.integerMultiply(qo.getCostPrice()));
		return dao.save(record);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public ItemSupplyVO getById(Long id) {
		ItemSupplyVO vo = new ItemSupplyVO();
		ItemSupply record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(ItemSupplyQO qo) {
		ItemSupply record = new ItemSupply();
		BeanUtils.copyProperties(qo, record);
		if (ObjectUtil.isNotNull(qo.getCostPrice())) {
			record.setCostPrice(BigDecimalUtils.integerMultiply(qo.getCostPrice()));
		}
		return dao.updateById(record);
	}

	public int statusById(ItemSupplyQO qo) {
		ItemSupply record = new ItemSupply();
		BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}

}
