package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Class ItemCatControlller ...
 *
 * @author LiJun
 * Created on 2019/2/16
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatControlller {
    @Autowired
    private ItemCatService itemCatService;

	/**
	 * 接收参数，parentId。调用Service查询分类类别，返回列表（json数据）
	 *
	 * @param parentId Long型整数
	 * @return json数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	private List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId){
		return itemCatService.getItemCatlist(parentId);
	}
}
