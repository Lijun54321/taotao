package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class PageController ...
 *
 * @author LiJun
 * Created on 2019/2/16
 */
@Controller
public class PageController {

    @RequestMapping("/")
    private String showIndex(){
        System.out.println("asdasdasdas");
        return "index";
    }

    @RequestMapping("/{page}")
    private String showPage(@PathVariable String page){
        return page;
    }
}
