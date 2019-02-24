package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.search.service
 * @date 19-2-23 下午4:29
 */
public interface SearchService {

	SearchResult search(String queryString, int page, int rows) throws Exception;

}
