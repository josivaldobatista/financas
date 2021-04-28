package com.jfb.financasapi.services;

import java.util.Optional;

import com.jfb.financasapi.dto.PessoaDTO;
import com.jfb.financasapi.entities.Pessoa;
import com.jfb.financasapi.repositories.PessoaRepository;
import com.jfb.financasapi.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository repository;

  @Transactional(readOnly = true)
  public PessoaDTO findById(Long id) {
    Optional<Pessoa> obj = repository.findById(id);
    Pessoa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));
    return new PessoaDTO(entity);
  }

  @Transactional(readOnly = true)
  public Page<PessoaDTO> findAll(PageRequest pageRequest) {
    Page<Pessoa> list = repository.findAll(pageRequest);
    return list.map(x -> new PessoaDTO(x));
  }

  @Transactional
  public PessoaDTO insert(PessoaDTO dto) {
    Pessoa entity = new Pessoa();
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);
    return new PessoaDTO(entity);
  }

  private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {
    entity.setNome(dto.getNome());
    entity.setAtivo(dto.getAtivo());
    entity.setEndereco(dto.getEndereco());
  }

}
