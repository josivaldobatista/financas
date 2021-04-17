package com.jfb.financasapi.services;

import com.jfb.financasapi.dto.CategoriaDTO;
import com.jfb.financasapi.entities.Categoria;
import com.jfb.financasapi.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repository;

  @Transactional(readOnly = true)
  public Page<CategoriaDTO> findAll(PageRequest pageRequest) {
    Page<Categoria> list = repository.findAll(pageRequest);
    return list.map(x -> new CategoriaDTO(x));
  }
  
}
