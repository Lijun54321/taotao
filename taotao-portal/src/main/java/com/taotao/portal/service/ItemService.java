package com.taotao.portal.service;

import com.taotao.pojo.TbItem;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service
 * @date 19-2-23 下午9:00
 */
public interface ItemService {

	TbItem getItemById(Long itemId);

	String getItemDescById(Long itemId);

	String getItemParamById(Long itemId);

}
