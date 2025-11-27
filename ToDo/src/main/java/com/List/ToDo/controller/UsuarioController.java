package com.List.ToDo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.List.ToDo.dto.UsuarioRequestDTO;
import com.List.ToDo.dto.UsuarioResponseDTO;
import com.List.ToDo.service.UsuarioService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	public UsuarioController (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping(value = "criarUsuario")
	public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioRequestDTO dto){
		return ResponseEntity.ok(usuarioService.criarUsuario(dto));
	}
	
	@GetMapping(value = "listarUsuarios")
	public List<UsuarioResponseDTO> listarUsuario() {
	    return usuarioService.listarUsuario();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> usuarioId(@PathVariable int id) {
		UsuarioResponseDTO usuario = usuarioService.usuarioId(id);

	    if (usuario != null) {
	        return ResponseEntity.ok(usuario); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado"); // 404
	    }
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> deletar(@PathVariable int id) {
		return ResponseEntity.ok(usuarioService.deletar(id));

	}
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody UsuarioRequestDTO novo) {
		return ResponseEntity.ok(usuarioService.atualizar(id, novo));
	}


}
