package com.taotao.rest.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.pojo.TBContent;
import com.taotao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.controller
 * @date 19-2-21 下午3:51
 */
@Controller
public class ContentController {
	@Autowired
	ContentService contentService;

	@RequestMapping("/content/{cid}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable Long cid){
		try {
			List<TBContent> contenList = contentService.getContentList(cid);
			return TaotaoResult.ok(contenList);
		}catch (Exception e){
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}


	}

}
