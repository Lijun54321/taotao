package com.taotao.rest.service;

import com.taotao.rest.pojo.ItemCatResult;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.service
 * @date 19-2-20 下午7:32
 */
public interface ItemCatService {

    /**
     * 获取商品分类的信息
     *
     * @return
     */
    ItemCatResult getItemCatList();

}
