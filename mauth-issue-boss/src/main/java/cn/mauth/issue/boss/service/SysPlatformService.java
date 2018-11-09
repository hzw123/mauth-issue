package cn.mauth.issue.boss.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.SysPlatformQO;
import cn.mauth.issue.boss.bean.vo.SysPlatformVO;
import cn.mauth.issue.common.dao.SysPlatformDao;
import cn.mauth.issue.common.entity.SysPlatform;
import cn.mauth.issue.common.example.SysPlatformExample;
import cn.mauth.issue.util.ArrayListUtil;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.util.enums.StatusIdEnum;
import com.xiaoleilu.hutool.crypto.SecureUtil;

/**
 * 授权客户端表
 *
 * @author mauth
 * @since 2017-12-27
 */
@Component
public class SysPlatformService {

	@Autowired
	private SysPlatformDao dao;

	public Page<SysPlatformVO> listForPage(int pageCurrent, int pageSize, SysPlatformQO qo) {
		SysPlatformExample example = new SysPlatformExample();
//		Criteria c = example.createCriteria();
		example.setOrderByClause(" id desc ");
		Page<SysPlatform> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, SysPlatformVO.class);
	}

	public int save(SysPlatformQO qo) {
		SysPlatform record = new SysPlatform();
		BeanUtils.copyProperties(qo, record);
		record.setPlatformAppId("RC" + SecureUtil.simpleUUID());
		record.setPlatformAppSecret(SecureUtil.simpleUUID());
		record.setStatusId(StatusIdEnum.NORMAL.getCode());
		return dao.save(record);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public SysPlatformVO getById(Long id) {
		SysPlatformVO vo = new SysPlatformVO();
		SysPlatform record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(SysPlatformQO qo) {
		SysPlatform record = new SysPlatform();
		BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}

	public List<SysPlatformVO> listAll() {
		List<SysPlatform> list = dao.listAll();
		return ArrayListUtil.copy(list, SysPlatformVO.class);
	}

}
