package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;


/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service
 * @date 19-2-20 下午9:02
 */
public interface ContentCategoryService {
    List<EasyUITreeNode> getContentCatList(Long parentId);

    TaotaoResult insertContentCatgory(Long parentId, String name);

    void updateContentCategory(Long id, String name);

    void deleteContentCategory(Long parentId, Long id);

    EasyUIDataGridResult getContentCategory(Integer page, Integer rows, Long categoryId);
}
