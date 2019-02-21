package com.taotao.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.controller
 * @date 19-2-21 下午3:20
 */
@Controller
public class TestClientController {

	@RequestMapping(value = "/testpost",method = RequestMethod.POST)
	@ResponseBody
	public String testClientPost(String name, String password){
		System.out.println("name = " + name + " pass = " + password);
		return "ok";
	}
}
