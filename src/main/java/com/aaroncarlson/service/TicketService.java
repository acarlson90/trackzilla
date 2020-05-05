package com.aaroncarlson.service;

import com.aaroncarlson.model.Ticket;

public interface TicketService {

    Iterable<Ticket> listTickets();

}
