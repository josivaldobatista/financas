package com.jfb.financasapi.services;

import java.util.Optional;

import com.jfb.financasapi.dto.PessoaDTO;
import com.jfb.financasapi.entities.Pessoa;
import com.jfb.financasapi.repositories.PessoaRepository;
import com.jfb.financasapi.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
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

}
