package com.aaroncarlson.controller;

import com.aaroncarlson.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @GetMapping("/releases")
    public String getReleases(Model model) {
        model.addAttribute("releases", releaseService.getAllReleases());
        return "releases";
    }

}
