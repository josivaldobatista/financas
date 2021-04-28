package com.jfb.financasapi.resources;

import java.net.URI;

import com.jfb.financasapi.dto.PessoaDTO;
import com.jfb.financasapi.services.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
  
  @Autowired
  private PessoaService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
    PessoaDTO dto = service.findById(id);
    return ResponseEntity.ok().body(dto);
  }

  @GetMapping
  public ResponseEntity<Page<PessoaDTO>> findAll(
    @RequestParam(value = "page", defaultValue = "0") Integer page,
    @RequestParam(value = "size", defaultValue = "12") Integer size,
    @RequestParam(value = "direction", defaultValue = "ASC") String direction,
    @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
    ) {
      PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
      Page<PessoaDTO> list = service.findAll(pageRequest);
      return ResponseEntity.ok().body(list);
  }

  @PostMapping
  public ResponseEntity<PessoaDTO> insert(@RequestBody PessoaDTO dto) {
    dto = service.insert(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
  }
}
