package com.taotao.sso.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.sso.service.LogoutService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全退出
 *
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.sso.controller
 * @date 19-2-24 下午7:08
 */

@Controller
public class LogoutController {

	@Autowired
	private LogoutService logoutService;

	@RequestMapping(value = "/user/logout/{token}")
	@ResponseBody
	public Object login(@PathVariable String token, String callback,
	                    HttpServletRequest request, HttpServletResponse response) {
		try {
			TaotaoResult result = logoutService.logout(token, request, response);
			// 支持jsonp调用
			if (StringUtils.isNotBlank(callback)) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}

	}

	/*@RequestMapping(value = "/user/logout/{token}")
	public void login(@PathVariable String token,
	                    HttpServletRequest request, HttpServletResponse response) {
			logoutService.logout(token, request, response);
	}*/
}
