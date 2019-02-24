package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.sso.service
 * @date 19-2-24 下午7:08
 */
public interface LogoutService {

	TaotaoResult logout(String token, HttpServletRequest request, HttpServletResponse response);
}
