package cn.spring.redis;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

public class TestString {
	
	public static void main(String[] args) {
		Jedis jedis = RedisProvider.getJedis();
		JSONObject city = new JSONObject();
		
		city.put("", "");
		
	}

}
