package cn.spring.test.service;

import java.util.List;
import java.util.Map;

import cn.spring.test.model.User;


public interface UserService {
	
	List<User> findUserList(Map<String, Object> selectParam)throws Exception;
	
	public Integer saveUser(User user)throws Exception;

}
