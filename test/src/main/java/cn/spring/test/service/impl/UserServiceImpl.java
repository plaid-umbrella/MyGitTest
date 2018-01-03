package cn.spring.test.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.spring.test.dao.UserDao;
import cn.spring.test.model.User;
import cn.spring.test.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	UserDao userDao;

	@Override
	public List<User> findUserList(Map<String, Object> selectParam) throws Exception{
		List<User> userList = userDao.selectUserList(selectParam);
		return userList;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public Integer saveUser(User user) throws Exception{
		userDao.insertUser(user);
//		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		user.setUserName(user.getUserName() + "111111111111111111");
		user.setUserName(null);
		userDao.insertUser(user);
		return 0;
	}

}
