package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TBContent;

import java.util.List;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.service
 * @date 19-2-21 下午3:42
 */
public interface ContentService {

	/**
	 * 根据cid查询内容列表
	 * @param cid 内容分类id category_id
	 * @return 列表
	 */
	List<TBContent> getContentList(Long cid);

	/**
	 * 根据cid 进行缓存同步(操作redis)
	 * @param cid 内容分类的id category_id
	 * @return 包装成功和不成功
	 */
	TaotaoResult syncContent(Long cid);
}
