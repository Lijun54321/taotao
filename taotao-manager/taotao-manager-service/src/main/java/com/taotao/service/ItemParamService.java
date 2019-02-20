package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service
 * @date 19-2-19 下午2:45
 */
public interface ItemParamService {
    TaotaoResult checkParam(Long cid);

    EasyUIDataGridResult getItemParamList(int page, int rows);

    TaotaoResult getItemByCid(Long cid);

    TaotaoResult insertItemParam(Long cid, String paramData);

    TaotaoResult deleteItemParam(String ids);

    TbItemParam getItemById(Long id);
}
