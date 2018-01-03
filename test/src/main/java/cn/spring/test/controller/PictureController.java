package cn.spring.test.controller;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.sf.json.JSONObject;

@Controller("pictureController")
@RequestMapping("picture")
public class PictureController {

	@RequestMapping("toPictureUpload")
	public String toPictureUpload(HttpServletRequest request, Model model) {

		return "picture";
	}

	@RequestMapping("savePicture")
	@ResponseBody
	public String savePicture(HttpServletRequest request, Model model) {
		JSONObject result = new JSONObject();
		try {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						// 重命名上传后的文件名
						String fileName = "demoUpload" + file.getOriginalFilename();
						System.out.println(fileName);
						// 定义上传路径
						String path = request.getSession().getServletContext().getRealPath("/")+"..\\uploadaaaaa\\";
						File f = new File(path);
						if (!f.exists()) {
							f.mkdir();
						}
						path = path + fileName;
						System.out.println(path);
						File localFile = new File(path);
						file.transferTo(localFile);
						System.out.println(localFile.getPath());
//						String path = "uploadaaaaa/" + fileName;
//						File f = new File("uploadaaaaa");
//						if (!f.exists()) {
//							f.mkdir();
//						}
//						File localFile = new File(path);
//						file.transferTo(localFile);
					}
				}
				// 记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}

			result.put("status", 1);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", 0);
		}
		return result.toString();
	}

}
