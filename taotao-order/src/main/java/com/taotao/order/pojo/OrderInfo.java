package com.taotao.order.pojo;

import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

import java.util.List;

/**
 * 包装一下订单的全部信息
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.order.pojo
 * @date 19-2-25 下午5:16
 */
public class OrderInfo extends TbOrder {

	private List<TbOrderItem> orderItems;

	private TbOrderShipping orderShipping;

	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}

	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
}
