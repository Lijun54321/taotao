package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Class ItemCatService ...
 *
 * @author LiJun
 * Created on 2019/2/16
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatlist(long parentId);

}
