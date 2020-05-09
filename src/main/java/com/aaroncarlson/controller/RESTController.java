package com.aaroncarlson.controller;

import com.aaroncarlson.model.Application;
import com.aaroncarlson.model.Ticket;
import com.aaroncarlson.service.ApplicationService;
import com.aaroncarlson.service.TicketService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RESTController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = Lists.newArrayList(ticketService.getAllTickets());
        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = Lists.newArrayList(applicationService.getAllApplications());
        return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") long id) {
        return new ResponseEntity<Application>(applicationService.getApplicationById(id), HttpStatus.OK);
    }

}
