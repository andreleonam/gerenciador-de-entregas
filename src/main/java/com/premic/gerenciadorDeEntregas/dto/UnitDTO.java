package com.premic.gerenciadorDeEntregas.dto;

import com.premic.gerenciadorDeEntregas.entities.Unit;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class UnitDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 5, message = "O tamanho deve ser entre 1 e 5 caracteres")
    private String acronym;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 1, max = 30, message = "O tamanho deve ser entre 1 e 30 caracteres")
    private String measure;

    public UnitDTO() {
    }

    public UnitDTO(Unit obj) {
        this.id = obj.getId();
        this.acronym = obj.getAcronym();
        this.measure = obj.getMeasure();
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

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
