package com.List.ToDo.controller;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.List.ToDo.dto.TarefaRequestDTO;
import com.List.ToDo.dto.TarefaResponseDTO;
import com.List.ToDo.service.TarefaService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("tarefa")
public class TarefaController {
	
	private final TarefaService tarefaService;
	
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
	
	@PostMapping(value = "criarTarefa")
	public ResponseEntity<?> criarTarefa(@Valid @RequestBody TarefaRequestDTO dto){
		tarefaService.criarTarefa(dto);
		return ResponseEntity.ok("Tarefa Criada com Sucesso!");
	}
	
	@GetMapping(value = "listarTarefas")
	public List<TarefaResponseDTO> listarTarefas() {
	    return tarefaService.listarTarefa();
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> deletar(@PathVariable int id) {
		return ResponseEntity.ok(tarefaService.deletar(id));

	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody TarefaRequestDTO novo) {
		return ResponseEntity.ok(tarefaService.atualizar(id, novo));
	}

	

}
