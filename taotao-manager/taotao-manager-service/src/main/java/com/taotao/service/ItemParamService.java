package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * 商品参数Service
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service
 * @date 19-2-19 下午2:45
 */
public interface ItemParamService {
	/**
	 * 获取商品参数表
	 *
	 * @param page
	 * @param rows
	 * @return
	 */
    EasyUIDataGridResult getItemParamList(int page, int rows);

	/**
	 * 根据商品分类id查询出商品参数
	 * @param cid 商品分类id
	 * @return ok(参数)
	 */
	TaotaoResult getItemByCid(Long cid);

	/**
	 * 插入相应的商品参数
	 * @param cid
	 * @param paramData
	 * @return
	 */
	TaotaoResult insertItemParam(Long cid, String paramData);

	/**
	 *
	 * @param ids
	 * @return
	 */
	TaotaoResult deleteItemParam(String ids);

    TbItemParam getItemById(Long id);
}
