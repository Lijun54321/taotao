package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class ItemController ...
 *
 * @author LiJun
 * Created on 2019/2/16
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

	/**
	 * 根据商品id获取商品信息
	 *
	 * @param itemId 商品id
	 * @return 商品信息
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable("itemId") Long itemId){
		return itemService.getItemById(itemId);
	}

	/**
	 * 机票去同一类商品的列表
	 * @param page 页码
	 * @param rows 每页数量
	 * @return 一个包装后的数据
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows){
		return itemService.getItemList(page, rows);
	}

	/**
	 * 保存一个商品
	 * @param item 商品具体内容
	 * @param desc 商品描述
	 * @param itemParams 商品参数
	 * @return ok
	 */
	@RequestMapping(value = "/item/save", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem item, String desc, String itemParams){
		return itemService.createItem(item,desc, itemParams);
	}

	/**
	 * 根据商品id展示相应的商品参数
	 * @param itemId id
	 * @param model 把数据放到model中
	 * @return 页面
	 */
	@RequestMapping("/page/item/{itemId}")
	public String showItemParam(@PathVariable Long itemId, Model model){
		String html = itemService.getItemParamHtml(itemId);
		model.addAttribute("myhtml", html);
		return "item-param";
	}

}
