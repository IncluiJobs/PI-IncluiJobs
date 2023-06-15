package com.generation.incluijobs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.incluijobs.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
	
	public List<Comentario> findAllByTextoContainingIgnoreCase (@Param("comentario") String comentario);

}
