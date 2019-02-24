package com.taotao.portal.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.pojo.TbUser;
import com.taotao.portal.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service.impl
 * @date 19-2-24 下午9:25
 */
@Service
public class UserServiceImpl implements UserService {

	@Value("${SSO_BASE_URL}")
	private String SSO_BASE_URL;
	@Value("${SSO_USER_TOKEN_SERVICE}")
	private String SSO_USER_TOKEN_SERVICE;


	@Override
	public TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 从cookie中取token
			String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
			// 判断token是否有值
			if (StringUtils.isBlank(token)) {
				return null;
			}
			// 调用sso的服务查询用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN_SERVICE + token);
			// 把json转换成java对象
			TaotaoResult result = TaotaoResult.format(json);

			if (result == null || result.getStatus() != 200) {
				return null;
			} else {
				// 取用户对象
				result = TaotaoResult.formatToPojo(json, TbUser.class);

				return (TbUser) result.getData();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}