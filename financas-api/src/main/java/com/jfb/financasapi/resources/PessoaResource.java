package com.jfb.financasapi.resources;

import com.jfb.financasapi.dto.PessoaDTO;
import com.jfb.financasapi.services.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
