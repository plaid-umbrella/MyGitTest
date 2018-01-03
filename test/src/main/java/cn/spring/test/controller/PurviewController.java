package cn.spring.test.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spring.test.model.Purview;
import cn.spring.test.service.PurviewService;
import net.sf.json.JSONObject;

@Controller("purviewController")
@RequestMapping("purview")
public class PurviewController {
	
	@Resource
	PurviewService purviewService;
	
	@RequestMapping("findPurviewList")
	@ResponseBody
	public String findPurviewList(HttpServletRequest request) {
		JSONObject result = new JSONObject();
		try {
			String parentId = request.getParameter("parentId");
			List<Purview> purviewList = purviewService.selectListByParentId(Integer.valueOf(parentId));
			result.put("status", "success");
			result.put("purviewList", purviewList);
			System.out.println(purviewList);
		} catch (Exception e) {
			result.put("status", "fail");
			e.printStackTrace();
		}
		return result.toString();
	}
	
	@RequestMapping("savePurview")
	@ResponseBody
	public String savePurview(HttpServletRequest request, Purview purview) {
		JSONObject result = new JSONObject();
		try {
			purviewService.insert(purview);
			result.put("status", "success");
		} catch (Exception e) {
			result.put("status", "fail");
			e.printStackTrace();
		}
		return result.toString();
	}
	
	@RequestMapping("updatePurview")
	@ResponseBody
	public String updatePurview(HttpServletRequest request, Purview purview) {
		JSONObject result = new JSONObject();
		try {
			purviewService.updateByPrimaryKeySelective(purview);
			result.put("status", "success");
		} catch (Exception e) {
			result.put("status", "fail");
			e.printStackTrace();
		}
		return result.toString();
	}
	
	@RequestMapping("deletePurview")
	@ResponseBody
	public String deletePurview(HttpServletRequest request, Purview purview) {
		JSONObject result = new JSONObject();
		try {
			purviewService.deleteByPrimaryKey(purview.getId());
			result.put("status", "success");
		} catch (Exception e) {
			result.put("status", "fail");
			e.printStackTrace();
		}
		return result.toString();
	}

}
