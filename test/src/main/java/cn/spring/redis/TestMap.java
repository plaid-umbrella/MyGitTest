package cn.spring.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class TestMap {

	public static void main(String[] args) {
		Jedis jedis = RedisProvider.getJedis();
//		Map<String, String> user = new HashMap<String, String>();
//		user.put("name", "aaa");
//		user.put("password", "789");
//
//		jedis.hmset("user", user);
		
		System.out.println(String.format("len:%d", jedis.hlen("user")));  //mapkey个数 
        System.out.println(String.format("keys: %s", jedis.hkeys("user") ));  //map中的所有键值
        System.out.println(String.format("values: %s", jedis.hvals("user") ));  //map中的所有value  
        
        List<String> rsmap = jedis.hmget("user", "name","password");  //取出map中的name、password字段值
        System.out.println(rsmap);  
		
	}

}
