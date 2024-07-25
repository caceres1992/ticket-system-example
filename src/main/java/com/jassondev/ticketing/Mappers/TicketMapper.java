package com.jassondev.ticketing.Mappers;

import com.jassondev.ticketing.DTOs.TicketDTO;
import com.jassondev.ticketing.DTOs.TicketUpdateDTO;
import com.jassondev.ticketing.models.Ticket;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketDTO ticketToTicketDTO(Ticket ticket);
    Ticket ticketDTOToTicket(TicketDTO ticketDTO);
    List<TicketDTO> ticketsToTicketsDTOs(List<Ticket> tickets);
    void updateDTOToTicket(TicketUpdateDTO ticketUpdateDTO, @MappingTarget Ticket ticket);
}