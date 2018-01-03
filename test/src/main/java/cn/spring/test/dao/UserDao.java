package cn.spring.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.spring.test.model.User;


@Repository("userDao")
public interface UserDao {
	
	List<User> selectUserList(Map<String, Object> selectParam);
	
	Integer insertUser(User user)throws Exception;

}
