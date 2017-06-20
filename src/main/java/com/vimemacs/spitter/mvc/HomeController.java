package com.vimemacs.spitter.mvc;

import com.vimemacs.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by HWD on 2017/6/19.
 */
// 声明为控制器
@Controller
public class HomeController {
    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

    private SpitterService spitterService;

    // 注入 SpitterService
    @Inject
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    // 处理对首页的请求
    @RequestMapping("/home")
    public String showHomePage(Map<String, Object> model) {
        // 将 Spittle 放入模型中
        model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));
        // 返回视图名称
        return "home";
    }
}
