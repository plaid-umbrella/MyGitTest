package cn.spring.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.spring.test.dao.PurviewDao;
import cn.spring.test.model.Purview;
import cn.spring.test.service.PurviewService;

@Service("purviewService")
public class PurviewServiceImpl implements PurviewService{

	@Resource
	PurviewDao purviewDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		purviewDao.deleteByPrimaryKey(id);
		return 0;
	}

	@Override
	public int insert(Purview record) {
		purviewDao.insert(record);
		return 0;
	}

	@Override
	public List<Purview> selectList() {
		List<Purview> purviewList = purviewDao.selectList();
		return purviewList;
	}

	@Override
	public Purview selectByPrimaryKey(Integer id) {
		Purview purview = purviewDao.selectByPrimaryKey(id);
		return purview;
	}

	@Override
	public int updateByPrimaryKeySelective(Purview record) {
		purviewDao.updateByPrimaryKeySelective(record);
		return 0;
	}

	@Override
	public List<Purview> selectListByParentId(Integer parentId) {
		List<Purview> purviewList = purviewDao.selectListByParentId(parentId);
		return purviewList;
	}
	
	
}
