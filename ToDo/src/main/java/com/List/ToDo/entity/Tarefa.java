package com.List.ToDo.entity;

import java.time.LocalDate;

import com.List.ToDo.dto.TarefaRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String descricao;
	private Status status;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	public Tarefa() {

	}

	public Tarefa(String nome, String descricao, Status status, LocalDate dataInicio, LocalDate dataFim) {
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	public Tarefa(TarefaRequestDTO dto) {
		this.nome = dto.getNome();
		this.descricao = dto.getDescricao();
		this.status = Status.PENDENTE;
		this.dataInicio = LocalDate.now();
	}


	public Tarefa(String nome, String descricao, Status status) {
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
