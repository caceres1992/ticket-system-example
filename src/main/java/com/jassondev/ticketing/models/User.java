//package com.jassondev.ticketing.models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//@Table(name = "app_user")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull
//    @Size(min = 3, max = 50)
//    private String username;
//
//    @NotNull
//    @Email
//    private String email;
//
//    @NotNull
//    @Size(min = 8)
//    private String password;
//
//    @NotNull
//    private String role;
//
//    @Column(nullable = false, updatable = false)
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//
//}
