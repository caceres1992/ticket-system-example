package com.jassondev.ticketing.services;

import com.jassondev.ticketing.DTOs.TicketUpdateDTO;
import com.jassondev.ticketing.Mappers.TicketMapper;
import com.jassondev.ticketing.exceptions.TicketNotFoundException;
import com.jassondev.ticketing.models.Ticket;
import com.jassondev.ticketing.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository repository;

    public List<Ticket> findAll() {
        return repository.findAll();
    }

    public Optional<Ticket> getTicketById(Long ticketID) {
        Optional<Ticket> ticket = repository.findById(ticketID);
        if (ticket.isPresent()) {
            return ticket;
        }
        return Optional.empty();
    }

    public Ticket createTicket(Ticket ticket) {
        return repository.save(ticket);
    }

    public Optional<Ticket> updateticket(Long ticketID, TicketUpdateDTO ticketUpdateDTO) {
        Optional<Ticket> ticketFound = repository.findById(ticketID);
        if (ticketFound.isPresent()) {
            Ticket ticket = ticketFound.get();
            TicketMapper.INSTANCE.updateDTOToTicket(ticketUpdateDTO,ticket);
            repository.save(ticket);
            return Optional.of(ticket);
        }
        return Optional.empty();
    }

    public void deleteTicket(Long ticketID) {
        repository.deleteById(ticketID);
    }

}
