package com.taotao.rest.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类列表查询
 *
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.service.impl
 * @date 19-2-20 下午7:33
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public ItemCatResult getItemCatList() {
        // 调用递归方法查询商品分类列表
        List itemCatList = getItemCatList(0L);
        // 返回结果
        ItemCatResult result = new ItemCatResult();
        result.setData(itemCatList);
        return result;
    }

    private List getItemCatList(Long parentId) {
        // 根据parentId插询列表
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        // 执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List resultList = new ArrayList();
        int index = 0;
        for (TbItemCat tbItemCat : list) {
            if(index >= 14){
                break;
            }
            // 如果是父节点
            if (tbItemCat.getIsParent()) {
                CatNode node = new CatNode();
                node.setUrl("/products/" + tbItemCat.getId() + ".html");
                // 如果当前节点为第一级节点
                if (tbItemCat.getParentId() == 0) {
                    node.setName("<a href='/products/" + tbItemCat.getId() + ".html'>" + tbItemCat.getName() + "</a>");
                    System.out.println("阿诗丹顿大多多多多多多多多多多多多多");
                    // 第一级节点不能超过14个元素， index为计数器
                    index++;
                } else {
                    node.setName(tbItemCat.getName());
                }
                node.setItems(getItemCatList(tbItemCat.getId()));
                // 把node添加到列表
                resultList.add(node);
            } else {
                // 如果是叶子节点
                String item = "/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName() + "电子书";
                resultList.add(item);
            }
        }
        return resultList;
    }
}
