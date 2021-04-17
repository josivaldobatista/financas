package com.jfb.financasapi.resources;

import com.jfb.financasapi.dto.CategoriaDTO;
import com.jfb.financasapi.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

  @Autowired
  private CategoriaService service;

  @GetMapping
  public ResponseEntity<Page<CategoriaDTO>> findAll(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "12") Integer size,
      @RequestParam(value = "direction", defaultValue = "ASC") String direction,
      @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
    PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
    Page<CategoriaDTO> listDto = service.findAll(pageRequest);
    return ResponseEntity.ok().body(listDto);
  }

}
