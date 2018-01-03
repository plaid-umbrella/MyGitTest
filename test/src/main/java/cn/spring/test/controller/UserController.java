package cn.spring.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spring.test.model.User;
import cn.spring.test.service.UserService;


@Controller("userController")
@RequestMapping("user")
public class UserController {
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	UserService userService;
	
	@RequestMapping("toUserList")
	public String toUserList(HttpServletRequest request, Model model){
		Map<String, Object> selectParam = new HashMap<String, Object>();
		try {
			List<User> userList = userService.findUserList(selectParam);
//			if (userList != null && userList.size() > 0) {
//				for (User user : userList) {
//					logger.info(user.getUserName());
//					logger.info(user.getLoginName());
//				}
//			}
			model.addAttribute("userList", userList);
		} catch (Exception e) {
			logger.error(e);
		}
		return "ztree";
	}
	
	@RequestMapping("saveUser")
	@ResponseBody
	public String saveUser(HttpServletRequest request, User user){
		JSONObject result = new JSONObject();
		try {
			userService.saveUser(user);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.put("status", 0);
		}
		return result.toString();
	}

}
