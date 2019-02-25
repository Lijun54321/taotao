package com.taotao.portal.service;

import com.taotao.portal.pojo.OrderInfo;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service
 * @date 19-2-25 下午7:03
 */
public interface OrderService {

	/**
	 * 创建订单
	 *
	 * @param orderInfo 订单信息
	 * @return 订单号
	 */
	String createOrder(OrderInfo orderInfo);
}
