package com.taotao.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TBContentMapper;
import com.taotao.pojo.TBContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service.impl
 * @date 19-2-21 下午2:48
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TBContentMapper contentMapper;
	@Override
	public TaotaoResult insertContent(TBContent content) {
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		contentMapper.insert(content);
		return TaotaoResult.ok();
	}
}
