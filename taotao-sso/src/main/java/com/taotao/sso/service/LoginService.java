package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.sso.service
 * @date 19-2-24 下午4:40
 */
public interface LoginService {
	/**
	 * 用户登录
	 *
	 * @param username 用户名
	 * @param password 用户密码
	 * @param request
	 * @param response
	 * @return
	 */
	TaotaoResult login(String username, String password, HttpServletRequest request,
	                   HttpServletResponse response);

	/**
	 * 根据token 取回用户信息
	 * @param token
	 * @return taotoResult
	 */
	TaotaoResult getUserByToken(String token);

}
