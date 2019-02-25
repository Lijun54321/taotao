package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 *
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.search.service
 * @date 19-2-23 下午4:29
 */
public interface SearchService {

	/**
	 * 根据关键字查找数据
	 *
	 * @param queryString 关键字
	 * @param page        页码
	 * @param rows        每页数量
	 * @return 查询到的结果
	 * @throws Exception
	 */
	SearchResult search(String queryString, int page, int rows) throws Exception;

}
