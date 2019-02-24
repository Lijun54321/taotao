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

	TbItem getItemById(Long itemId);

	TbItemDesc getItemDescById(Long itemId);

	TbItemParamItem getItemParamById(Long itemId);

}
