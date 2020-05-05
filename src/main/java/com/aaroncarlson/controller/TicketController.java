package com.aaroncarlson.controller;

import com.aaroncarlson.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public String getTickets(Model model) {
        model.addAttribute("tickets", ticketService.listTickets());
        return "tickets";
    }

}
