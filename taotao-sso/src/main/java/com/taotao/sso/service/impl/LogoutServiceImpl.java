package com.taotao.sso.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.sso.component.JedisClient;
import com.taotao.sso.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.sso.service.impl
 * @date 19-2-24 下午7:09
 */
@Service
public class LogoutServiceImpl implements LogoutService {

	@Autowired
	private JedisClient jedisClient;

	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;

	@Override
	public TaotaoResult logout(String token,
	                           HttpServletRequest request, HttpServletResponse response) {

		jedisClient.del(REDIS_SESSION_KEY + ":" + token);

		CookieUtils.deleteCookie(request, response, "TT_TOKEN");
		return TaotaoResult.ok();
	}
}
