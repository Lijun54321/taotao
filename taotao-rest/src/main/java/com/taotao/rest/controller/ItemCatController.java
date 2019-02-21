package com.taotao.rest.controller;

import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;
import com.taotao.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品分类查询
 *
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.rest.controller
 * @date 19-2-20 下午7:53
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    // products 解决返回的字符串乱码
    @RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String getItemCatList(String callback) {
        ItemCatResult result = itemCatService.getItemCatList();
        // 把result转换成字符串
        String json = JsonUtils.objectToJson(result);
        if (StringUtils.isBlank(callback)) {
            return json;
        }
        // 如果字符串不为空，需要支持jsonp调用
        return callback + "(" + json + ");";
    }

    // 需要SpringMvc版本是4.1 及以上
    @RequestMapping(value = "/list2")
    @ResponseBody
    public Object getItemCatList2(String callback) {
        ItemCatResult result = itemCatService.getItemCatList();
        if (StringUtils.isBlank(callback)) {
            return result;
        }
        // 如果字符串不为空，需要支持jsonp调用
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
