package com.jfb.financasapi.services;

import java.util.Optional;

import com.jfb.financasapi.dto.CategoriaDTO;
import com.jfb.financasapi.entities.Categoria;
import com.jfb.financasapi.repositories.CategoriaRepository;
import com.jfb.financasapi.services.exceptions.ResourceNotFoundException;

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

  @Transactional(readOnly = true)
  public CategoriaDTO findById(Long id) {
    Optional<Categoria> obj = repository.findById(id);
    Categoria entity = obj.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
    return new CategoriaDTO(entity);
  }

  @Transactional
  public CategoriaDTO insert(CategoriaDTO dto) {
    Categoria entity = new Categoria();
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);
    return new CategoriaDTO(entity);
  }

  private void copyDtoToEntity(CategoriaDTO dto, Categoria entity) {
    entity.setNome(dto.getNome());
  }

}
