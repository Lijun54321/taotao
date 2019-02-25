package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TBContent;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service
 * @date 19-2-21 下午2:47
 */
public interface ContentService {
	/**
	 * 插入一个分类的具体内容
	 *
	 * @param content 内容
	 * @return ok
	 */
	TaotaoResult insertContent(TBContent content);
}
