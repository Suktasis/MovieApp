package com.kristupas.MovieApp.models;

import javax.persistence.*;


@MappedSuperclass
public abstract class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String dateOfBirth;



    @Lob
    private Byte[] preview;

    @ManyToOne
    Country country;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Byte[] getPreview() {
        return preview;
    }

    public void setPreview(Byte[] preview) {
        this.preview = preview;
    }

}
