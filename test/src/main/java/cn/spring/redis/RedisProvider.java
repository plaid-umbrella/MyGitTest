package cn.spring.redis;

//import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisProvider {

	private static Logger logger = Logger.getLogger(RedisProvider.class);
	protected static JedisPool jedispool;
	protected static int EXPIRE = 1200;
	static {
//		ResourceBundle bundle = ResourceBundle.getBundle("redis.properties");
//		if (bundle == null) {
//			throw new IllegalArgumentException("[redis.properties] is not found!");
//		}

//		EXPIRE = Integer.valueOf(bundle.getString("redis.expire"));

		JedisPoolConfig jedisconfig = new JedisPoolConfig();
//		jedisconfig.setMaxActive(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
//
//		jedisconfig.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
//
//		jedisconfig.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
//
//		jedisconfig.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
//
//		jedisconfig.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
//
//		jedispool = new JedisPool(jedisconfig, bundle.getString("redis.ip"), Integer.valueOf(bundle.getString("redis.port")), 100000);
		
		jedisconfig.setMaxActive(10);

		jedisconfig.setMaxIdle(5);

		jedisconfig.setMaxWait(100000);

		jedisconfig.setTestOnBorrow(true);

		jedisconfig.setTestOnReturn(true);

		jedispool = new JedisPool(jedisconfig, "192.168.216.133", 6379, 100000);
	}

	public static Jedis getJedis() {
		Jedis jedis = null;
		try {
			jedis = jedispool.getResource();
		} catch (JedisConnectionException jce) {
			logger.error("获取redis链接报错");
			ExceptionUtil.getTrace(jce);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				ExceptionUtil.getTrace(e);
			}
			jedis = jedispool.getResource();
		}
		return jedis;
	}

	public static void returnResource(JedisPool pool, Jedis jedis) {
		if (jedis != null) {
			pool.returnResource(jedis);
		}
	}
}
