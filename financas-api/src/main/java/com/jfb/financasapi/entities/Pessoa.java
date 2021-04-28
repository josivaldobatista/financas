package com.jfb.financasapi.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private Boolean ativo;

  @Embedded
  private Endereco endereco;

  public Pessoa() {
  }

  public Pessoa(Long id, String nome, Boolean ativo, Endereco endereco) {
    this.id = id;
    this.nome = nome;
    this.ativo = ativo;
    this.endereco = endereco;
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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Pessoa)) {
      return false;
    }
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(id, pessoa.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}
