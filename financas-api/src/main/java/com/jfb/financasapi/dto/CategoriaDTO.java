package com.jfb.financasapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.jfb.financasapi.entities.Categoria;

public class CategoriaDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private Long id;

  @Size(min = 3, max = 20)
  @NotBlank
  private String nome;

  public CategoriaDTO() {
  }

  public CategoriaDTO(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public CategoriaDTO(Categoria entity) {
    id = entity.getId();
    nome = entity.getNome();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
