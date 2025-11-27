package com.List.ToDo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.List.ToDo.dto.UsuarioRequestDTO;
import com.List.ToDo.dto.UsuarioResponseDTO;
import com.List.ToDo.entity.Usuario;
import com.List.ToDo.repositories.UsuarioRepository;


@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	//metodo post
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        Usuario user = new Usuario(dto);
        usuarioRepository.save(user);
        UsuarioResponseDTO response = new UsuarioResponseDTO(user);
        return response;
    }
    
    //metodo get
    public List<UsuarioResponseDTO> listarUsuario() {
	    return usuarioRepository.findAll()
	            .stream()
	            .map(usuario -> new UsuarioResponseDTO(
	                    usuario.getId(),
	                    usuario.getNome(),
	                    usuario.getEmail()
	            ))
	            .toList();
	}
    
    //metodo get
    public UsuarioResponseDTO usuarioId(int id) {
		return usuarioRepository.findById((long) id)
		.map(usuario ->(new UsuarioResponseDTO(usuario)))
        .orElse(null); 
	}
    
    //metodo delete
    public String deletar(int id) {
		if(usuarioRepository.existsById((long) id)) {
			usuarioRepository.deleteById((long) id);
		
			return ("Excluido com sucesso");
		}else {
		
			return ("Esse id não existe");
		}

	}
    
    //metodo put
    public UsuarioResponseDTO atualizar( int id,UsuarioRequestDTO novo) {
	    Optional<Usuario> usuarioExistente = usuarioRepository.findById((long) id);
	    
	    if (usuarioExistente.isPresent()) {
	        Usuario usuario = usuarioExistente.get();
	        
	        usuario.setNome(novo.getNome());
	        usuario.setEmail(novo.getEmail());
	        usuario.setSenha(novo.getSenha());
	        
	        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
	        
	        UsuarioResponseDTO response = new UsuarioResponseDTO(usuarioAtualizado);
	        return response;
	    } else {
	        return null;
	    }
	}
	

}
