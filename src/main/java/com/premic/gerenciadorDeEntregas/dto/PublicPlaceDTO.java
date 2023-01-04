package com.premic.gerenciadorDeEntregas.dto;

import com.premic.gerenciadorDeEntregas.entities.PublicPlace;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class PublicPlaceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 3, message = "O tamanho deve ser entre 1 e 3 caracteres")
    private String acronym;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 30, message = "O tamanho deve ser entre 3 e 30 caracteres")
    private String name;

    public PublicPlaceDTO() {
    }

    public PublicPlaceDTO(PublicPlace obj) {
        this.id = obj.getId();
        this.acronym = obj.getAcronym();
        this.name = obj.getName();
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
}
