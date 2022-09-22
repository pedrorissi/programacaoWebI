package br.com.senac.service;

import java.util.List;
import java.util.Optional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senac.entity.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository repo;
	
	public List<Professor> buscarTodosProfessores(){
		return repo.findAll();
	}
	
	public Professor salvar(Professor professor) {
		return repo.save(professor);
	}
	
	public Professor buscarPorId(Integer id) {
		String resposta = "Professor não encontrado";
		Optional<Professor> professor = repo.findById(id);
		return professor.orElseThrow(() -> new ObjectNotFoundException(1L,resposta));
	}
	
	public void removerPorId(Integer id) {
		repo.deleteById(id);
	}

}
