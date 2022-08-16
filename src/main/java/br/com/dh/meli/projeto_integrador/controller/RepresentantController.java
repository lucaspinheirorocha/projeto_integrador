package br.com.dh.meli.projeto_integrador.controller;

import br.com.dh.meli.projeto_integrador.dto.RepresentantDTO;
import br.com.dh.meli.projeto_integrador.service.IRepresentantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/representant")
public class RepresentantController {
    @Autowired
    private IRepresentantService service;

    @PostMapping
    public ResponseEntity<RepresentantDTO> create(@RequestBody RepresentantDTO representantDTO) {
        RepresentantDTO representantCreated = service.create(representantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(representantCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepresentantDTO> update(
            @RequestBody RepresentantDTO representantDTO,
            @PathVariable Long id) {
        RepresentantDTO representantCreated = service.update(id, representantDTO);
        return ResponseEntity.status(HttpStatus.OK).body(representantCreated);
    }
}
