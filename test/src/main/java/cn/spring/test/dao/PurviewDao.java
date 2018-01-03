package cn.spring.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.spring.test.model.Purview;

@Repository("purviewDao")
public interface PurviewDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Purview record);

    List<Purview> selectList();

    Purview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Purview record);
    
    List<Purview> selectListByParentId(Integer parentId);
}
