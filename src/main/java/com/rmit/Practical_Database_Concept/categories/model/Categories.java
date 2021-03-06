package com.rmit.Practical_Database_Concept.categories.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "Categories")
@Getter
@Setter
@NoArgsConstructor
public class Categories {

    /**
     * Id
     * GeneratedValue(generator = "UUID")
     * GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
     * Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
     * private UUID id;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "categories_name", columnDefinition = "VARCHAR(100)")
    @NotBlank
    private String categories_name;

    @Column(name = "categories_description", columnDefinition = "TEXT")
    @NotBlank
    private String categories_description;

    public Categories(@JsonProperty("id") int id,
                      @JsonProperty("categories_name") String categories_name,
                      @JsonProperty("categories_description") String categories_description) {
        this.id = id;
        this.categories_name = categories_name;
        this.categories_description = categories_description;
    }
}
