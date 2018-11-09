package cn.mauth.issue.boss.service;

import java.util.HashMap;
import java.util.List;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.SupplyInfoQO;
import cn.mauth.issue.boss.bean.vo.SupplyInfoVO;
import cn.mauth.issue.common.dao.SupplyInfoDao;
import cn.mauth.issue.common.entity.SupplyInfo;
import cn.mauth.issue.common.example.SupplyInfoExample;
import cn.mauth.issue.common.example.SupplyInfoExample.Criteria;
import cn.mauth.issue.util.ArrayListUtil;
import cn.mauth.issue.util.ConfigUtil;
import cn.mauth.issue.util.HttpRestUtil;
import cn.mauth.issue.util.PingyinUtil;
import cn.mauth.issue.util.base.Result;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.util.enums.StatusIdEnum;

/**
 * 商户信息
 *
 * @author mauth
 * @since 2017-12-19
 */
@Component
public class SupplyInfoService {

	@Autowired
	private SupplyInfoDao dao;

	public Page<SupplyInfoVO> listForPage(int pageCurrent, int pageSize, SupplyInfoQO qo) {
		SupplyInfoExample example = new SupplyInfoExample();
		Criteria c = example.createCriteria();

		/** 判断是否是管理员*/
		if(!SessionUtils.isAdmin()){
			c.andParaUserIdEqualTo(SessionUtils.getUserInfoId().toString());
		}

		example.setOrderByClause(" id desc ");
		Page<SupplyInfo> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, SupplyInfoVO.class);
	}

	public int save(SupplyInfoQO qo) {
		SupplyInfo record = new SupplyInfo();
		BeanUtils.copyProperties(qo, record);
		record.setSupplyCode(PingyinUtil.toPingyin(qo.getSupplyName()));
		record.setStatusId(StatusIdEnum.NORMAL.getCode());
		return dao.save(record);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public SupplyInfoVO getById(Long id) {
		SupplyInfoVO vo = new SupplyInfoVO();
		SupplyInfo record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(SupplyInfoQO qo) {
		SupplyInfo record = new SupplyInfo();
		BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}

	public List<SupplyInfoVO> listAll() {
		List<SupplyInfo> list = dao.listByStatusId(StatusIdEnum.NORMAL.getCode());
		return ArrayListUtil.copy(list, SupplyInfoVO.class);
	}

	public Page<SupplyInfoVO> lookup(int pageCurrent, int pageSize, SupplyInfoQO qo) {
		SupplyInfoExample example = new SupplyInfoExample();
		Criteria c = example.createCriteria();
		c.andStatusIdEqualTo(StatusIdEnum.NORMAL.getCode());
		example.setOrderByClause(" id desc ");
		Page<SupplyInfo> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, SupplyInfoVO.class);
	}

	@SuppressWarnings("rawtypes")
	public Result<HashMap> balance(String supplyCode) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("supplyCode", supplyCode);
		return HttpRestUtil.getForResultObject(ConfigUtil.BALANCE_QUERY_URL, map, HashMap.class);
	}

}
