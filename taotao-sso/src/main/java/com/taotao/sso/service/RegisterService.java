package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.sso.service
 * @date 19-2-24 下午4:02
 */
public interface RegisterService {
	/**
	 * 检验数据有效性
	 *
	 * @param param 数据
	 * @param type  数据类型 1、2、3分别代表username、phone、email
	 * @return
	 */
	TaotaoResult checkData(String param, int type);

	/**
	 * 注册
	 * @param user 用户信息
	 * @return ok
	 */
	TaotaoResult register(TbUser user);

}
