package com.taotao.portal.service;

import com.taotao.portal.pojo.SearchResult;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service
 * @date 19-2-23 下午5:30
 */
public interface SearchService {
	/**
	 * 根据keyword分页查询商品
	 *
	 * @param keyword 关键字
	 * @param page    页码
	 * @param rows    每页数量
	 * @return 查询到的结果
	 */
	SearchResult search(String keyword, int page, int rows);
}
