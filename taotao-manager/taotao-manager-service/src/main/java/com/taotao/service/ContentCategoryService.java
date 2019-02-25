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

	/**
	 * 获取分类的内容
	 *
	 * @param parentId 父节点的id
	 * @return 查询到的节点
	 */
	List<EasyUITreeNode> getContentCatList(Long parentId);

	/**
	 * 插入一个分类
	 * @param parentId 这个分类的父节点id
	 * @param name 分类name
	 * @return ok
	 */
	TaotaoResult insertContentCatgory(Long parentId, String name);

	/**
	 * 编辑名字后更新数据库 通过id查询更新其name
	 * @param id 编辑的分类id
	 * @param name 分类的新名字
	 */
	void updateContentCategory(Long id, String name);

	/**
	 * 删除一个分类
	 * @param parentId 父节点id
	 * @param id 分类id
	 */
	void deleteContentCategory(Long parentId, Long id);

	/**
	 * 获取分类内容 分页
	 * @param page 页数
	 * @param rows 每页条数
	 * @param categoryId 分类id
	 * @return EasyUIDataGridResult
	 */
	EasyUIDataGridResult getContentCategory(Integer page, Integer rows, Long categoryId);
}
