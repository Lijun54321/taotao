package com.taotao.portal.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.controller
 * @date 19-2-25 下午2:15
 */
@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	/**
	 * 往购物车里面添加相应的商品
	 *
	 * @param itemId   商品id
	 * @param itemNum  商品数量
	 * @param response 因为需要将数据存到cookie中 需要request和response
	 * @param request  因为需要将数据存到cookie中 需要request和response
	 * @return 添加成功页面
	 */
	@RequestMapping("/cart/add/{itemId}")
	public String addCart(@PathVariable Long itemId, Integer itemNum,
	                      HttpServletResponse response, HttpServletRequest request) {
		TaotaoResult result = cartService.addCart(itemId, itemNum, request, response);
		return "cart-success";
	}

	/**
	 * 查看购物车
	 * @param model 添加数据
	 * @param request 需要获取cookie中的数据
	 * @return
	 */
	@RequestMapping("/cart/cart")
	public String showCartList(Model model, HttpServletRequest request) {
		List<CartItem> list = cartService.getCartItems(request);
		model.addAttribute("cartList", list);

		return "cart";
	}

	/**
	 * 更新购物车终端的商品数据
	 * @param itemId 商品id
	 * @param num 商品数量
	 * @param response 因为需要将数据存到cookie中 需要request和response
	 * @param request 因为需要将数据存到cookie中 需要request和response
	 * @return ok
	 */
	@RequestMapping("/cart/update/num/{itemId}/{num}")
	@ResponseBody
	public TaotaoResult updateCartItemNum(@PathVariable Long itemId, @PathVariable Integer num,
	                                      HttpServletResponse response, HttpServletRequest request) {
		return cartService.updateCartItem(itemId, num, request, response);
	}

	/**
	 * 删除购物车中的商品
	 * @param itemId 商品id
	 * @param response 因为需要将数据存到cookie中 需要request和response
	 * @param request 因为需要将数据存到cookie中 需要request和response
	 * @return 刷新一下页面
	 */
	@RequestMapping("/cart/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId,
	                             HttpServletResponse response, HttpServletRequest request) {
		cartService.deleteCartItem(itemId, request, response);
		return "redirect:/cart/cart.html";
	}
}