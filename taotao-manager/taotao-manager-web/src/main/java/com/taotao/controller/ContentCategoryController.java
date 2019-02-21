package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品内容分类管理Controller
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.controller
 * @date 19-2-20 下午9:13
 */
@Controller
@RequestMapping("/content")
public class ContentCategoryController {
    @Autowired
    ContentCategoryService contentCategoryService ;

    @RequestMapping("/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId){
        return contentCategoryService.getContentCatList(parentId);
    }

    @RequestMapping("/category/create")
    @ResponseBody
    public TaotaoResult createNode(Long parentId, String name){
        return contentCategoryService.insertContentCatgory(parentId, name);
    }

    @RequestMapping("/category/update")
    public void updateNode(Long id, String name){
        contentCategoryService.updateContentCategory(id, name);
    }

    @RequestMapping("/category/delete")
    @ResponseBody
    public String updateNode(Long parentId,Long id){
        contentCategoryService.deleteContentCategory(parentId, id);
        return "success";
    }

    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentCategory(Integer page, Integer rows, Long categoryId){
        // 打印参数信息
        // System.out.println("page = "+page +" rows = "+rows +" category = "+categoryId);
        return contentCategoryService.getContentCategory(page, rows, categoryId);
    }
}
