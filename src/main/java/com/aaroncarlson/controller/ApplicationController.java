package com.aaroncarlson.controller;

import com.aaroncarlson.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/applications")
    public String getApplications(Model model) {
        model.addAttribute("applications", applicationService.listApplications());
        return "applications";
    }

}
