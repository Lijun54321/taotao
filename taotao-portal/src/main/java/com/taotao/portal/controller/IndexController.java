package com.taotao.portal.controller;

import com.taotao.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页访问Controller
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.controller
 * @date 19-2-20 下午6:32
 */
@Controller
public class IndexController {
    @Autowired
    private ContentService contentService;

    @RequestMapping("/index")
    public String showIndex(Model model){
        // 取大广告位内容
        String json = contentService.getAd1List();
        // 传递给页面
        model.addAttribute("ad1", json);
        return "index";
    }
}
