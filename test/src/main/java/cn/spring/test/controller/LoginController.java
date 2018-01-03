package cn.spring.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spring.test.model.User;


@Controller("loginController")
@RequestMapping("login")
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("login")
	@ResponseBody
	public String userLogin(HttpServletRequest request){
		logger.info("logger-----info-----：这里是执行登录");
		JSONObject result = new JSONObject();
		String password = request.getParameter("password");
		password = StringUtils.isNotEmpty(password) ? password : "";
		String loginName = request.getParameter("loginName");
		loginName = StringUtils.isNotEmpty(loginName) ? loginName : "";
		try {
			User user = new User();
			user.setLoginName("aa");
			user.setPassword("123");
			if (loginName.equals(user.getLoginName()) && password.equals(user.getPassword())) {
				result.put("status", "1");//登录成功
				//用户信息放到session中
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			} else {
				result.put("status", "2");//用户名或密码有误 
			}
		} catch (Exception e) {
			result.put("status", "0");//网络异常
			e.printStackTrace();
		}
		return result.toString();
	}

}
