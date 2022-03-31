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
	private ProfessorRepository profRepo;
	
	public List<Professor> listaTodosProfessores(){
		return profRepo.findAll();
	}

	public Professor buscarPorId(Integer id) throws ObjectNotFoundException {
		Optional<Professor> professor = profRepo.findById(id);
		return professor.orElseThrow(() -> new ObjectNotFoundException(null, "Objeto não encontrado"));
		
	}
	
	public Professor salvar(Professor professor) {
		return profRepo.save(professor);
	}
	
	
	public void excluir(Integer id) {
		profRepo.deleteById(id);
	}
	
	public Professor alterar(Professor objProfessor) {
		Professor professor = buscarPorId(objProfessor.getId());
		professor.setNome(objProfessor.getNome());
		return salvar(professor);
	}
}
