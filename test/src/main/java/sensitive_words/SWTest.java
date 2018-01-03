package sensitive_words;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SWTest {
	
	public static void main(String[] args) {
		try {
			String words = "滚犊子,傻逼,傻叉,傻X";
			String [] wordArr = words.split(",");
			List<String> sensitiveWords = new ArrayList<>();
			for (int i = 0; i < wordArr.length; i++) {
				sensitiveWords.add(wordArr[i]);
			}
			SensitiveWordInit sensitiveWordInit = new SensitiveWordInit();
			Map sensitiveWordMap = sensitiveWordInit.initKeyWord(sensitiveWords);
			SensitivewordEngine.sensitiveWordMap = sensitiveWordMap;
			
			Set<String> filter = SensitivewordEngine.getSensitiveWord("过傻滤敏感傻X词出错傻逼", 2);
			System.out.println(filter.toString());
		} catch (Exception e) {
			System.out.println("过滤敏感词出错，请联系维护人员");
			e.printStackTrace();
		}
	}

}
