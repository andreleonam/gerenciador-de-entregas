package com.premic.gerenciadorDeEntregas.dto;

import com.premic.gerenciadorDeEntregas.entities.Category;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")

    private String nome;

    public CategoryDTO() {
    }

    public CategoryDTO(Category obj) {
        this.id = obj.getId();
        this.nome = obj.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
