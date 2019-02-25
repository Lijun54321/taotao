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

	TaotaoResult addCart(Long itemId, Integer num,
	                     HttpServletRequest request, HttpServletResponse response);

	List<CartItem> getCartItems(HttpServletRequest request);

	TaotaoResult updateCartItem(long itemId, Integer num, HttpServletRequest request,
	                            HttpServletResponse response);

	TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
