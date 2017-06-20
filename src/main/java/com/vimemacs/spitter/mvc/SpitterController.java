package com.vimemacs.spitter.mvc;

import com.vimemacs.spitter.domain.Spitter;
import com.vimemacs.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.inject.Inject;

/**
 * Created by HWD on 2017/6/20.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private final SpitterService spitterService;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value="/spittles", method=GET)
    public String listSpittlesForSpitter(@RequestParam("spitter") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);

        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));

        return "spittles/list";
    }

}
