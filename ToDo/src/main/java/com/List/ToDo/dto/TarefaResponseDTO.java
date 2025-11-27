package com.List.ToDo.dto;

import java.time.LocalDate;

import com.List.ToDo.entity.Status;
import com.List.ToDo.entity.Tarefa;



public class TarefaResponseDTO {
	
	private String nome;
	private String descricao;
	private Status status;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	public TarefaResponseDTO(String nome, String descricao, Status status, LocalDate dataInicio, LocalDate dataFim) {

		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	public TarefaResponseDTO() {
	}

	public TarefaResponseDTO(Tarefa tarefa) {
	    this.nome = tarefa.getNome();
	    this.descricao = tarefa.getDescricao();
	    this.status = tarefa.getStatus();
	    this.dataInicio = tarefa.getDataInicio();
	    this.dataFim = tarefa.getDataFim();
	}

	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
	


}
