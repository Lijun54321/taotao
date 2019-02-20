package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Class ItemService ...
 *
 * @author LiJun
 * Created on 2019/2/16
 */
public interface ItemService {
    TbItem getItemById(Long id);

    EasyUIDataGridResult getItemList(int page, int rows);

    TaotaoResult createItem(TbItem item, String  desc, String itemParam);

    String getItemParamHtml(Long itemId);

}
