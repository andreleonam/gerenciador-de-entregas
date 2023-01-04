package com.premic.gerenciadorDeEntregas.entities;

import java.io.Serializable;
import java.util.Objects;

public class PublicPlace implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private String acronym;
    private String name;

    public PublicPlace() {
    }

    public PublicPlace(Long id, String acronym, String name) {
        this.id = id;
        this.acronym = acronym;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublicPlace that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
