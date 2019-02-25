package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.service
 * @date 19-2-25 下午1:57
 */
public interface CartService {

	/**
	 * 往购物车里面添加相应的商品
	 *
	 * @param itemId   商品id
	 * @param num      商品数量
	 * @param response 因为需要将数据存到cookie中 需要request和response
	 * @param request  因为需要将数据存到cookie中 需要request和response
	 * @return 添加成功页面
	 */
	TaotaoResult addCart(Long itemId, Integer num,
	                     HttpServletRequest request, HttpServletResponse response);

	/**
	 * 查看购物车
	 * @param request 需要获取cookie中的数据
	 * @return
	 */
	List<CartItem> getCartItems(HttpServletRequest request);

	/**
	 * 更新购物车终端的商品数据
	 * @param itemId 商品id
	 * @param num 商品数量
	 * @param response 因为需要将数据存到cookie中 需要request和response
	 * @param request 因为需要将数据存到cookie中 需要request和response
	 * @return ok
	 */
	TaotaoResult updateCartItem(long itemId, Integer num, HttpServletRequest request,
	                            HttpServletResponse response);

	/**
	 * 删除购物车中的商品
	 * @param itemId 商品id
	 * @param response 因为需要将数据存到cookie中 需要request和response
	 * @param request 因为需要将数据存到cookie中 需要request和response
	 * @return 刷新一下页面
	 */
	TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
