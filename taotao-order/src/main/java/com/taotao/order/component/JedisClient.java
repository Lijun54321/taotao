package com.taotao.order.component;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.component
 * @date 19-2-21 下午8:29
 */
public interface JedisClient {

	String set(String key, String value);

	String get(String key);

	Long hset(String key, String item, String value);

	String hget(String key, String item);

	Long incr(String key);

	Long decr(String key);

	Long expire(String key, int second);

	Long ttl(String key);

	public Long hdel(String key, String item);

}
