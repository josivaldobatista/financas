package com.jfb.financasapi.dto;

import java.io.Serializable;

import com.jfb.financasapi.entities.Endereco;
import com.jfb.financasapi.entities.Pessoa;

public class PessoaDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String nome;
  private Boolean ativo;
  private Endereco endereco;

  public PessoaDTO() {
  }

  public PessoaDTO(Long id, String nome, Boolean ativo, Endereco endereco) {
    this.id = id;
    this.nome = nome;
    this.ativo = ativo;
    this.endereco = endereco;
  }

  public PessoaDTO(Pessoa entity) {
    id = entity.getId();
    nome = entity.getNome();
    ativo = entity.getAtivo();
    endereco = entity.getEndereco();
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

  public Boolean isAtivo() {
    return this.ativo;
  }

  public Boolean getAtivo() {
    return this.ativo;
  }

  public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
  }

  public Endereco getEndereco() {
    return this.endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

}
