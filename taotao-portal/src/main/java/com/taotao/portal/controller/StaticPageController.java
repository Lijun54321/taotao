package com.taotao.portal.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.portal.service.StaticPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.controller
 * @date 19-2-23 下午10:42
 */
@Controller
public class StaticPageController {

	@Autowired
	private StaticPageService staticPageService;

	/**
	 * 根据商品id 获取商品的html
	 *
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/gen/item/{itemId}")
	@ResponseBody
	public TaotaoResult genItemPage(@PathVariable Long itemId) {
		try {
			return staticPageService.genItemHtml(itemId);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}