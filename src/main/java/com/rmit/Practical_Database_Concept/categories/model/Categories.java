package com.rmit.Practical_Database_Concept.categories.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "Categories")
@NoArgsConstructor
public class Categories {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "categories_name", columnDefinition = "VARCHAR(100)")
    @NotBlank
    private String categories_name;

    @Column(name = "categories_description", columnDefinition = "TEXT")
    @NotBlank
    private String categories_description;

    public Categories(@JsonProperty("id") UUID id,
                      @JsonProperty("categories_name") String categories_name,
                      @JsonProperty("categories_description") String categories_description) {
        this.id = id;
        this.categories_name = categories_name;
        this.categories_description = categories_description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(String categories_name) {
        this.categories_name = categories_name;
    }

    public String getCategories_description() {
        return categories_description;
    }

    public void setCategories_description(String categories_description) {
        this.categories_description = categories_description;
    }
}
