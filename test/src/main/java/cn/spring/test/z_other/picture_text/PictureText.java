package cn.spring.test.z_other.picture_text;

import cn.spring.test.z_other.picture_text.util.FileUtil;

import java.net.URLEncoder;

import cn.spring.test.z_other.picture_text.util.Base64Util;
import cn.spring.test.z_other.picture_text.util.HttpUtil;

public class PictureText {

	public static void main(String[] args) {
		// 通用识别url
		String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
		// 本地图片路径
		String filePath = "#####本地文件路径#####";
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			 */
			String accessToken = "#####调用鉴权接口获取的token#####";
			String result = HttpUtil.post(otherHost, accessToken, params);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
