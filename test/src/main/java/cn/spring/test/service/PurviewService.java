package cn.spring.test.service;

import java.util.List;

import cn.spring.test.model.Purview;

public interface PurviewService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(Purview record);

    List<Purview> selectList();

    Purview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Purview record);
    
    List<Purview> selectListByParentId(Integer parentId);
}
