package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service
 * @date 19-2-24 下午9:24
 */
public interface UserService {

	TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response);


}
