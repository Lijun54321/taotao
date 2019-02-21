package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TBContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.controller
 * @date 19-2-21 下午2:50
 */
@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	ContentService contentService;

	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TBContent content){
		return contentService.insertContent(content);
	}
}
