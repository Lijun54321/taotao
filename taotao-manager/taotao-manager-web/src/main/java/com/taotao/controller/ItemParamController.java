package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品规格参数模板管理Controller
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.controller
 * @date 19-2-19 下午2:43
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    /**
     * 查询商品规格参数模板存在与否
     * @param cid 商品id
     * @return
     */
    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult getItemByCid(@PathVariable Long cid){
        return itemParamService.getItemByCid(cid);
    }

    @RequestMapping("/cid/{cid}")
    @ResponseBody
    public TaotaoResult cid(@PathVariable Long cid){
        return itemParamService.getItemByCid(cid);
    }

    /**
     * 展示商品规格参数
     * @param page pageSize
     * @param rows 每页多少条
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemParamList(Integer page, Integer rows){
        return itemParamService.getItemParamList(page, rows);
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData){
        return itemParamService.insertItemParam(cid, paramData);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteItemParam(String ids){


        return itemParamService.deleteItemParam(ids);
    }


    @RequestMapping("/edit/{id}")
    public String itemParamEdit(@PathVariable Long id, Model model){
        System.out.println(id);

        TbItemParam itemParam = itemParamService.getItemById(id);

        if(itemParam == null){
            model.addAttribute("error", "id错误");
        }else{
            model.addAttribute("itemParam", itemParam);
        }
        return "item-param-edit";
    }

}
