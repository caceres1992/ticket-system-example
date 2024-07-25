package com.jassondev.ticketing.controllers;
import com.jassondev.ticketing.DTOs.TicketDTO;
import com.jassondev.ticketing.DTOs.TicketUpdateDTO;
import com.jassondev.ticketing.Mappers.TicketMapper;
import com.jassondev.ticketing.models.Ticket;
import com.jassondev.ticketing.services.TicketService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;


    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAll() {
        return ResponseEntity
                .ok(TicketMapper.INSTANCE.ticketsToTicketsDTOs(ticketService.findAll()));
    }

    @GetMapping("/{ticketID}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long ticketID) {
        Optional<Ticket> ticket = ticketService.getTicketById(ticketID);
        return ticket.map(value ->
                        ResponseEntity.ok(TicketMapper.INSTANCE.ticketToTicketDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket
            (@Valid @RequestBody TicketDTO ticketDTO) {
        Ticket ticket = TicketMapper.INSTANCE.ticketDTOToTicket(ticketDTO);
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(TicketMapper.INSTANCE.ticketToTicketDTO(createdTicket));
    }

    @PutMapping("/{ticketID}")
    public ResponseEntity<TicketDTO> updateTicket
            (@PathVariable Long ticketID, @Valid @RequestBody TicketUpdateDTO ticketUpdateDTO) {
        Optional<Ticket> updatedTicket = ticketService.updateticket(ticketID, ticketUpdateDTO);
        return updatedTicket.map(value-> ResponseEntity.ok(TicketMapper.INSTANCE.ticketToTicketDTO(value)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
