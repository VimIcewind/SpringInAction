package com.vimemacs.spitter.mvc;

import com.vimemacs.spitter.domain.Spitter;
import com.vimemacs.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by HWD on 2017/6/20.
 */
@Controller
@RequestMapping("/spitters")
public class SpitterController {
    private final SpitterService spitterService;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/spittles", method = GET)
    public String listSpittlesForSpitter(@RequestParam("spitter") String username, Model model) {
        Spitter spitter = spitterService.getSpitter(username);

        model.addAttribute(spitter);
        model.addAttribute(spitterService.getSpittlesForSpitter(username));

        return "spittles/list";
    }

    @RequestMapping(method = GET, params = "new")
    public String createSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method = POST)
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "spitters/edit";
        }
        spitterService.saveSpitter(spitter);
        return "redirect:/spitters/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        return "spitters/view";
    }
}
