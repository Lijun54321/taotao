package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Class ItemService ...
 *
 * @author LiJun
 * Created on 2019/2/16
 */
public interface ItemService {
	/**
	 * 根据商品id获取商品信息
	 *
	 * @param id 商品id
	 * @return 商品pojo
	 */
	TbItem getItemById(Long id);

	/**
	 * 获取商品分页信息
	 * @param page 页数
	 * @param rows 每页数量
	 * @return EasyUIDataGridResult
	 */
	EasyUIDataGridResult getItemList(int page, int rows);

	/**
	 * 新建一个商品
	 * @param item 商品信息
	 * @param desc 商品描述
	 * @param itemParam 商品参数
	 * @return ok
	 */
	TaotaoResult createItem(TbItem item, String  desc, String itemParam);

	/**
	 * 根据商品id获取商品参数的html代码
	 * @param itemId 商品id
	 * @return 生成的html代码
	 */
	String getItemParamHtml(Long itemId);

}
