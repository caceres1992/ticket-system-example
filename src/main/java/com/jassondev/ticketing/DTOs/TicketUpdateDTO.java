package com.jassondev.ticketing.DTOs;

import com.jassondev.ticketing.models.EPriority;
import com.jassondev.ticketing.models.TicketStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TicketUpdateDTO
        (

                String title,
                String description,
                TicketStatus status,
                LocalDateTime createdAt,
                EPriority priority
        ) {
}
