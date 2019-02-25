package com.taotao.portal.controller;

import com.taotao.pojo.TbItem;
import com.taotao.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 展示商品详情页面
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.controller
 * @date 19-2-23 下午9:07
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 通过商品id获取商品信息
	 *
	 * @param itemId 商品id
	 * @param model  写入数据
	 * @return 视图
	 */
	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId, Model model){
		TbItem item = itemService.getItemById(itemId);
		model.addAttribute("item", item);

		return "item";
	}

	/**
	 * 通过商品id获取商品描述信息
	 * @param itemId 商品id
	 * @return json数据
	 */
	@RequestMapping(value="/item/desc/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemDesc(@PathVariable Long itemId) {
		return itemService.getItemDescById(itemId);
	}

	/**
	 * 通过商品id获取商品参数
	 * @param itemId 商品id
	 * @return 查到的html代码
	 */
	@RequestMapping(value="/item/param/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemParam(@PathVariable Long itemId) {
		return itemService.getItemParamById(itemId);
	}

}
