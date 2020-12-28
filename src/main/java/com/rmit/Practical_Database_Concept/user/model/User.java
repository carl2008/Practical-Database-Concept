package com.rmit.Practical_Database_Concept.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * Id
     * GeneratedValue(generator = "UUID")
     * GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
     * Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
     * private UUID id;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private int id;

    @Column(name = "username", unique=true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "roles", columnDefinition = "NOT NULL DEFAULT ROLE_USER")
    private String roles;

    @Column(name = "is_active", columnDefinition = "NOT NULL DEFAULT 1")
    private boolean isActive;
}
