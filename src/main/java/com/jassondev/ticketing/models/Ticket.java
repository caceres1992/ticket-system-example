package com.jassondev.ticketing.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Setter
@Getter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Title cannot be null")
    @Size( min = 5, max = 100,message = "Title must be between 5 and 100 characters")
    private String title;
    @NotNull(message = "Description cannot be null")
    @Size(min = 10, message = "Description must be at least 10 characters long")
    private String description;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status cannot be null")
    private TicketStatus status;
    private EPriority priority;
    private LocalDateTime createAt ;
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreated(){
        status = TicketStatus.OPEN;
        createAt= LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Tag> tags;
//    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments;


}
