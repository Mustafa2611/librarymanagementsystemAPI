package com.BMS.librarymanagementsystem.librarymanagementsystem.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "patrons")
public class Patron implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String contactInformation;

    // Constructors, getters, and setters

    // Constructors
    public Patron() {
    }

    public Patron(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
