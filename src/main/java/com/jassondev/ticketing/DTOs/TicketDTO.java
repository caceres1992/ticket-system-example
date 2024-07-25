package com.jassondev.ticketing.DTOs;

import com.jassondev.ticketing.models.EPriority;
import com.jassondev.ticketing.models.TicketStatus;

import java.time.LocalDateTime;

public record TicketDTO(
        Long id,
        String title,
        String description,
        TicketStatus status,
        EPriority priority,
        LocalDateTime createAt,
        LocalDateTime updatedAt
) {
}
