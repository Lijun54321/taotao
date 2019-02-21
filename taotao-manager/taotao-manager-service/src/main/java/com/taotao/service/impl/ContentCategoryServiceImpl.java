package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TBContentMapper;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.*;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品内容分类管理Service
 *
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service.impl
 * @date 19-2-20 下午9:05
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Autowired
	private TBContentMapper tbContentMapper;

	@Override
	public List<EasyUITreeNode> getContentCatList(Long parentId) {
		// 根据parentId查询子节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		TbContentCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<EasyUITreeNode> resultList = new ArrayList<>();
		// 执行查询
		List<TbContentCategory> tbContentCategories = contentCategoryMapper.selectByExample(example);
		// 转换成EasyUITreeNode列表
		for (TbContentCategory tbContentCategory : tbContentCategories) {
			// c创建一个EasyUITreeNode节点
			EasyUITreeNode node = new EasyUITreeNode();

			node.setText(tbContentCategory.getName());
			node.setId(tbContentCategory.getId());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			// 添加到列表
			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public TaotaoResult insertContentCatgory(Long parentId, String name) {
		// 创建一个pojo对象
		TbContentCategory category = new TbContentCategory();
		category.setParentId(parentId);
		category.setName(name);
		category.setStatus(1);
		category.setIsParent(false);
		// '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数'
		category.setSortOrder(1);

		Date date = new Date();
		category.setCreated(date);
		category.setUpdated(date);
		System.out.println(category + "     asddddddddddddd ");
		// 插入数据
		contentCategoryMapper.insert(category);
		System.out.println(category);
		// 取返回的主键
		Long id = category.getId();
		// 判断父节点的isParent属性
		// 查询父节点
		TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parentNode.getIsParent()) {
			parentNode.setIsParent(true);
			// 更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		// 返回主键
		return TaotaoResult.ok(id);
	}

	@Override
	public void updateContentCategory(Long id, String name) {
		TbContentCategory category = new TbContentCategory();
		category.setId(id);
		category.setUpdated(new Date());
		category.setName(name);
		contentCategoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	public void deleteContentCategory(Long parentId, Long id) {
		// 首先前台传入的参数parentId 没有，只有id 我们先查出相应的节点
		TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(id);
		// 如果他是父节点，删除它自身包括其所有的叶子节点
		if (category.getIsParent()) {
			TbContentCategoryExample example = new TbContentCategoryExample();
			TbContentCategoryExample.Criteria criteria = example.createCriteria();
			criteria.andParentIdEqualTo(id);
			contentCategoryMapper.deleteByExample(example);
			category.setIsParent(false);
			contentCategoryMapper.updateByPrimaryKeySelective(category);
			deleteContentCategory(null, category.getId());
		}
		// 如果他是叶子节点 获取它的父节点 再删除
		if (!category.getIsParent()) {
			Long parentId1 = category.getParentId();
			contentCategoryMapper.deleteByPrimaryKey(id);
			TbContentCategoryExample example = new TbContentCategoryExample();
			TbContentCategoryExample.Criteria criteria = example.createCriteria();
			criteria.andParentIdEqualTo(parentId1);
			List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
			if (list == null || list.size() <= 0) {
				TbContentCategory category1 = new TbContentCategory();
				category1.setId(parentId1);
				category1.setIsParent(false);
				contentCategoryMapper.updateByPrimaryKeySelective(category1);
			}
		}
	}

	@Override
	public EasyUIDataGridResult getContentCategory(Integer page, Integer rows, Long categoryId) {
		// 设置查询条件
		TBContentExample example = new TBContentExample();
		TBContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo((long) categoryId);
		// 执行查询 并分页
		PageHelper.startPage(page, rows);
		List<TBContent> list = tbContentMapper.selectByExampleWithBLOBs(example);
		PageInfo<TBContent> info = new PageInfo<>(list);
		// 返回结果
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(info.getTotal());
		result.setRows(list);

		return result;
	}
}
