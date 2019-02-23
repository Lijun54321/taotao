package com.taotao.jedis;

import com.taotao.rest.component.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.jedis
 * @date 19-2-21 下午7:58
 */
public class JedisTest {
	// 单机版redis测试
	@Test
	public void testJedisSingle() throws Exception {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("hello", "hello jedis");
		String hello = jedis.get("hello");
		System.out.println(hello);
		jedis.close();
	}

	// 使用连接池
	@Test
	public void testJedisPool() throws Exception {
		// 创建一个连接池对象
		// 系统中应该是单例的
		JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
		// 从连接池中获取一个链接
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get("hello");
		System.out.println(result);
		// jedis 一定要关闭
		jedis.close();
		// 当系统关闭时 关闭连接池
		jedisPool.close();
	}

	// 集群redis测试
	@Test
	public void testJedisCluster() throws Exception {
		// 创建一个JedisCluster对象

		//指定每一个节点的地址
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("127.0.0.1", 7001));
		nodes.add(new HostAndPort("127.0.0.1", 7002));
		nodes.add(new HostAndPort("127.0.0.1", 7003));
		nodes.add(new HostAndPort("127.0.0.1", 7004));
		nodes.add(new HostAndPort("127.0.0.1", 7005));
		nodes.add(new HostAndPort("127.0.0.1", 7006));
		System.out.println(nodes);

		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("name", "zhangsan");
		jedisCluster.set("value", "100");
		String name = jedisCluster.get("name");
		String value = jedisCluster.get("value");
		System.out.println(name + "\n" + value);

		// 系统关闭是关闭
		jedisCluster.close();
	}

	@Test
	public void testJedisClientSpring() throws Exception {
		// 创建一个Spring容器
		ApplicationContext applicationContext = new
				ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

		// 从容器中获取JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);

		// 使用JedisClient
		/*jedisClient.set("client1", "100");
		String client = jedisClient.get("client1");*/
		String client = jedisClient.hget("REDIS_CONTENT_KEY", 89 + "");
		System.out.println(client);
	}

}