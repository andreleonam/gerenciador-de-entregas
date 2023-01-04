package com.premic.gerenciadorDeEntregas.dto;

import com.premic.gerenciadorDeEntregas.entities.State;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class StateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long Id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 2, max = 2, message = "O tamanho deve ser de 2 caracteres")
    private String acronym;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String name;

    public StateDTO() {
    }

    public StateDTO(State obj) {
        Id = obj.getId();
        this.acronym = obj.getAcronym();
        this.name = obj.getName();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
