package sensitive_words;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

public class Test {
	
	private static Map<String, Object> wordMap = new HashMap<>();
	
	public static void main(String[] args) {
		String words = "滚犊子,傻逼,傻叉,傻X,擦";
		String [] wordArr = words.split(",");
//		for (int i = 0; i < wordArr.length; i++) {
//			System.out.println(wordArr[i]);
//		}
//		for (int i = 0; i < wordArr.length; i++) {
//			System.out.print(wordArr[i]);
//			System.out.print("    ");
//			String [] wArr = wordArr[i].split("");
//			for (int j = 0; j < wArr.length; j++) {
//				System.out.print(wArr[j]);
//				System.out.print("    ");
//				if (j == 0) {
//					if (wordMap.containsKey(wArr[j])) {
//						
//					} else {
//						wordMap.put(wArr[j], "1");
//					}
//				} else {
//					
//				}
//				
//			}
//			System.out.println();
//		}
		Set<String> keyWordSet = new HashSet<>();
		keyWordSet.add("滚犊子");
		keyWordSet.add("傻逼");
		keyWordSet.add("傻叉");
		keyWordSet.add("傻X");
		keyWordSet.add("擦");
		addSensitiveWordToHashMap(keyWordSet);
		
		System.out.println("========================");
		System.out.println(sensitiveWordMap.get("傻"));
		Object wordMap = sensitiveWordMap.get("傻");
		System.out.println(sensitiveWordMap.get("滚"));
		System.out.println(sensitiveWordMap.get("擦"));
	}
	
	private static Map<String, Object> sensitiveWordMap = new HashMap<>();
	private static void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        sensitiveWordMap = new HashMap(keyWordSet.size());     //初始化敏感词容器，减少扩容操作
        System.out.println("keyWordSet.size()=" + keyWordSet.size());
        String key = null;  
        Map nowMap = null;
        Map<String, String> newWorMap = null;
        //迭代keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();
        while(iterator.hasNext()){
            key = iterator.next();    //关键字
//            System.out.println("关键字key=" + key);
            nowMap = sensitiveWordMap;
//            System.out.println("key.length()=" + key.length());
            for(int i = 0 ; i < key.length() ; i++){
                char keyChar = key.charAt(i);       //转换成char型
                Object wordMap = nowMap.get(keyChar);       //获取
                
                if(wordMap != null){        //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                }
                else{     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<String,String>();
                    newWorMap.put("isEnd", "0");     //不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }
                
                if(i == key.length() - 1){
                    nowMap.put("isEnd", "1");    //最后一个
                }
            }
        }
    }
	
	
	public static Map putword(String word) {
		Map<String, Object> temp = new HashMap<>();
		
		return temp;
	}

}
