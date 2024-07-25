package com.jassondev.ticketing.exceptions;

public class TicketNotFoundException extends Throwable {
    public TicketNotFoundException(String message) {
        super(message);
    }
}
