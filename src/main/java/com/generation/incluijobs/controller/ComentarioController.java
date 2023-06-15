package com.generation.incluijobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.incluijobs.model.Comentario;
import com.generation.incluijobs.repository.ComentarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping
    public ResponseEntity<List<Comentario>> getAll() {
        return ResponseEntity.ok(comentarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> getById(@PathVariable Long id) {
        return comentarioRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Comentario> post(@Valid @RequestBody Comentario comentario) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(comentarioRepository.save(comentario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> put(@RequestBody Comentario comentario){
    	return ResponseEntity.status(HttpStatus.OK).body(comentarioRepository.save(comentario));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        comentarioRepository.deleteById(id);
    }
}