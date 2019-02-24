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

	TaotaoResult checkData(String param, int type);

	TaotaoResult register(TbUser user);

}
