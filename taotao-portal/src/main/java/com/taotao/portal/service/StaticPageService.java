package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service
 * @date 19-2-23 下午10:17
 */
public interface StaticPageService {

	TaotaoResult genItemHtml(Long itemId) throws Exception;

}
