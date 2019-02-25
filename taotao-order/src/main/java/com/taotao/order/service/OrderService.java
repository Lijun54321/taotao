package com.taotao.order.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.order.pojo.OrderInfo;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.order.service
 * @date 19-2-25 下午6:15
 */
public interface OrderService {
	/**
	 * 创建一个订单
	 *
	 * @param orderInfo 数据
	 * @return ok
	 */
	TaotaoResult createOrder(OrderInfo orderInfo);
}
