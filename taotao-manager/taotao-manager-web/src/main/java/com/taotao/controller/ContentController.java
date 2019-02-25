package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.pojo.TBContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String  REST_CONTENT_SYNC_URL;

	@Autowired
	ContentService contentService;

	/**
	 * 保存一个内容的详细信息，并同步缓存(redis)
	 *
	 * @param content 内容
	 * @return 参数
	 */
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TBContent content){
		TaotaoResult taotaoResult = contentService.insertContent(content);
		// 调用taotao-rest发布的服务，同步缓存
		HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
		return taotaoResult;
	}
}
