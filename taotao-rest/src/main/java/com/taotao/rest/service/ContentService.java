package com.taotao.rest.service;

import com.taotao.pojo.TBContent;

import java.util.List;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.service
 * @date 19-2-21 下午3:42
 */
public interface ContentService {

	List<TBContent> getContentList(Long cid);
}
