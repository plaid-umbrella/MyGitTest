package cn.spring.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class Test {

	
	public static void main(String[] args) {
		Jedis jedis = RedisProvider.getJedis();
		
//		jedis.lpush("listDemo", "A");  
//        jedis.lpush("listDemo", "B");  
//        jedis.lpush("listDemo", "C");
		
//		 jedis.del("listDemo"); 
		//System.out.println(jedis.lrange("listDemo", 0, -3)); 
//		System.out.println(jedis.lrange("listDemo", 0, -2)); 
		 
//        System.out.println(jedis.lrange("listDemo", 0, -1));//全部  
        //全部  
		
//		jedis.lset("listDemo", 0, "123456");
        
        System.out.println(jedis.lrange("listDemo", 0, 0));//-3
        System.out.println(jedis.lrange("listDemo", 0, -3)); 
        
        System.out.println(jedis.lrange("listDemo", 0, 1));
        System.out.println(jedis.lrange("listDemo", 0, 3-2));//-2
        
        
        System.out.println(jedis.lrange("listDemo", 0, 2)); 
        System.out.println(jedis.lrange("listDemo", 0, 3-1));//-1
        
        List<String> list = jedis.lrange("listDemo", 0, -1);
        System.out.println("list=: " + list);
        
	}
	
}
