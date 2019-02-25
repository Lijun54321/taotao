package com.taotao.portal.service;

import com.taotao.pojo.TbItem;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service
 * @date 19-2-23 下午9:00
 */
public interface ItemService {
	/**
	 * 通过商品id获取商品信息
	 *
	 * @param itemId 商品id
	 * @return 商品信息
	 */
	TbItem getItemById(Long itemId);

	/**
	 * 通过商品id获取商品描述信息
	 * @param itemId 商品id
	 * @return 参数来的内容
	 */
	String getItemDescById(Long itemId);

	/**
	 * 通过商品id获取商品参数
	 * @param itemId 商品id
	 * @return 查到的html代码
	 */
	String getItemParamById(Long itemId);

}
