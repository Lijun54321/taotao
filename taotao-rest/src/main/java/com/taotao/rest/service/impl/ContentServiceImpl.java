package com.taotao.rest.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TBContentMapper;
import com.taotao.pojo.TBContent;
import com.taotao.pojo.TBContentExample;
import com.taotao.rest.component.JedisClient;
import com.taotao.rest.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容查询服务
 *
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.service.impl
 * @date 19-2-21 下午3:42
 */
@Service
public class ContentServiceImpl implements ContentService {
	@Value("${REDIS_CONTENT_KEY}")
	String REDIS_CONTENT_KEY;

	@Autowired
	private TBContentMapper tbContentMapper;

	@Autowired
	JedisClient jedisClient;

	@Override
	public List<TBContent> getContentList(Long cid) {
		// 添加缓存
		// 查询数据库之前先查询缓存 如果有直接返回
		try {
			// 从Redis中去缓存数据
			String json = jedisClient.hget(REDIS_CONTENT_KEY, cid + "");
			if (!StringUtils.isBlank(json)) {
				// 把json转换成List
				List<TBContent> contentList = JsonUtils.jsonToList(json, TBContent.class);
				return contentList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根据cid查询内容列表
		TBContentExample example = new TBContentExample();
		TBContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TBContent> list = tbContentMapper.selectByExampleWithBLOBs(example);

		// 返回结果的之前 ，向缓存中添加数据
		// 保证不影响正常业务逻辑
		try {
			// 为了规范key 可以使用hash
			// 顶一个保存内容的key hash的每个项都是cid
			// value是list  需要吧list转换成json数据

			jedisClient.hset(REDIS_CONTENT_KEY, cid + "", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TaotaoResult syncContent(Long cid) {
		jedisClient.hdel(REDIS_CONTENT_KEY, cid + "");
		return TaotaoResult.ok();
	}
}
