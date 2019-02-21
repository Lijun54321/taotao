package com.taotao.rest.service.impl;

import com.taotao.mapper.TBContentMapper;
import com.taotao.pojo.TBContent;
import com.taotao.pojo.TBContentExample;
import com.taotao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private TBContentMapper tbContentMapper;

	@Override
	public List<TBContent> getContentList(Long cid) {
		// 根据cid查询内容列表
		TBContentExample example = new TBContentExample();
		TBContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);

		return tbContentMapper.selectByExampleWithBLOBs(example);
	}
}
