package com.taotao.order.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.order.pojo.OrderInfo;
import com.taotao.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 生成订单服务
 *
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.order.controller
 * @date 19-2-25 下午6:30
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * 创建一个订单
	 *
	 * @param orderInfo 前台传来的数据
	 * @return ok
	 */
	@RequestMapping(value = "/order/create", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createOrder(@RequestBody OrderInfo orderInfo) {
		try {
			return orderService.createOrder(orderInfo);

		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}

