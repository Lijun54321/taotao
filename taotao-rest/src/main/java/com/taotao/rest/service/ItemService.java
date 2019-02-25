package com.taotao.rest.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.service
 * @date 19-2-23 下午7:44
 */
public interface ItemService {

	/**
	 * 通过商品id获取商品信息
	 *
	 * @param itemId 商品id
	 * @return 查询到的商品结果
	 */
	TbItem getItemById(Long itemId);

	/**
	 * 通过商品id获取商品描述信息
	 * @param itemId 商品id
	 * @return 查询到的商品结果
	 */
	TbItemDesc getItemDescById(Long itemId);

	/**
	 * 通过商品id获取商品参数信息
	 * @param itemId 商品id
	 * @return 查询到的商品结果
	 */
	TbItemParamItem getItemParamById(Long itemId);

}
