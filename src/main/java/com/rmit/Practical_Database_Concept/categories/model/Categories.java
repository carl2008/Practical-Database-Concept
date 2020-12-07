package com.rmit.Practical_Database_Concept.categories.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rmit.Practical_Database_Concept.movie.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
    /**
     * Id
     * GeneratedValue(generator = "UUID")
     * GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
     * Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
     * private int id;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "categories_name", nullable = false, columnDefinition = "VARCHAR(100)")
    @NotBlank
    private String categories_name;

    @Column(name = "categories_description", nullable = false, columnDefinition = "TEXT")
    @NotBlank
    private String categories_description;
}
