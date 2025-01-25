package dev.srijit.BookMyShow.controller;

import dev.srijit.BookMyShow.model.Ticket;
import dev.srijit.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired // create the dependency and inject inside controller
    private TicketService ticketService;

    @GetMapping("/hello")
    public ResponseEntity greet() {
        String greet = ticketService.greet();
        return ResponseEntity.ok(greet);
    }
}
