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

	/**
	 * 通过token获取用户信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response);


}
