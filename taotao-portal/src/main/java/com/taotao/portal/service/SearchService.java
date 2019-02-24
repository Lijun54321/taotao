package com.taotao.portal.service;

import com.taotao.portal.pojo.SearchResult;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service
 * @date 19-2-23 下午5:30
 */
public interface SearchService {

	SearchResult search(String keyword, int page, int rows);
}
