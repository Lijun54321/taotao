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
	/**
	 * 接收参数parentId，根据parentId查询分类列表。返回pojo列表
	 *
	 * @param parentId int
	 * @return list
	 */
	List<EasyUITreeNode> getItemCatlist(long parentId);

}
