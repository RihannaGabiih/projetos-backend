package com.List.ToDo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.List.ToDo.dto.TarefaRequestDTO;
import com.List.ToDo.dto.TarefaResponseDTO;
import com.List.ToDo.entity.Status;
import com.List.ToDo.entity.Tarefa;
import com.List.ToDo.repositories.TarefaRepository;

@Service
public class TarefaService {

	private final TarefaRepository tarefaRepository;

	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}

	// metodo post
	public void criarTarefa(TarefaRequestDTO dto) {
		Tarefa task = new Tarefa(dto.getNome(), dto.getDescricao(), Status.PENDENTE);
		tarefaRepository.save(task);
	}

	// metodo post
	public void criarTarefa1(TarefaRequestDTO dto) {
		Tarefa task = new Tarefa(dto);
		tarefaRepository.save(task);
	}

	// metodo get
	public List<TarefaResponseDTO> listarTarefa() {
		return tarefaRepository.findAll().stream().map(tarefa -> new TarefaResponseDTO(tarefa.getNome(),
				tarefa.getDescricao(), tarefa.getStatus(), tarefa.getDataInicio(), null)).toList();
	}
	
	 //metodo delete
    public String deletar(int id) {
		if(tarefaRepository.existsById((long) id)) {
			tarefaRepository.deleteById((long) id);
		
			return ("Tarefa excluida com sucesso");
		}else {
		
			return ("Essa tarefa não existe");
		}

	}
    
    //metodo put
    public TarefaResponseDTO atualizar(int id, TarefaRequestDTO novo) {

        Optional<Tarefa> tarefaExistente = tarefaRepository.findById((long) id);

        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();

            tarefa.setNome(novo.getNome());
            tarefa.setDescricao(novo.getDescricao());
            tarefa.setStatus(novo.getStatus());

            Tarefa tarefaAtualizada = tarefaRepository.save(tarefa);

            return new TarefaResponseDTO(tarefaAtualizada);

        } else {
            return null;
        }
    }

	
}
