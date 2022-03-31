package br.com.senac.inicializacao;





import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Disciplina;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AlunoRepository;
import br.com.senac.repository.DisciplinaRepository;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.repository.TurmaRepository;

@Component
public class Init implements ApplicationListener <ContextRefreshedEvent> {
	
	@Autowired
	AlunoRepository alunoRepo;
	
	@Autowired
	ProfessorRepository profRepo;
	
	@Autowired
	TurmaRepository turmaRepo;
	
	@Autowired
	DisciplinaRepository discRepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Bruno");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Gustavo");
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Flávio");
		
		
		alunoRepo.save(aluno1);
		alunoRepo.save(aluno2);
		alunoRepo.save(aluno3);
		alunoRepo.save(aluno4);
		
		Professor professor1 = new Professor();
		professor1.setNome("Marcelo");
		
		profRepo.save(professor1);
		
		Disciplina java = new Disciplina();
		java.setNome("JAVA I");
		
		Disciplina java2 = new Disciplina();
		java2.setNome("JAVA II");
		
		Disciplina arquitetura = new Disciplina();
		arquitetura.setNome("arquitetura");
		
		discRepo.saveAll(Arrays.asList(java, java2, arquitetura));
		
		Turma ads = new Turma();
		Turma rede = new Turma();
		
		ads.setNome("ADS");
		turmaRepo.save(ads);
		
		rede.setNome("REDES");
		turmaRepo.save(rede);
		
		aluno1.setTurma(ads);
		aluno2.setTurma(ads);
		aluno3.setTurma(rede);
		aluno4.setTurma(rede);
		
		alunoRepo.save(aluno1);
		alunoRepo.save(aluno2);
		alunoRepo.save(aluno3);
		alunoRepo.save(aluno4);
		
		
		
		aluno1.setDisciplinas(Arrays.asList(java, arquitetura));
		aluno2.setDisciplinas(Arrays.asList(java, arquitetura));
		aluno3.setDisciplinas(Arrays.asList(java, java2));
		aluno4.setDisciplinas(Arrays.asList(java, java2));
		
		alunoRepo.save(aluno1);
		alunoRepo.save(aluno2);
		alunoRepo.save(aluno3);
		alunoRepo.save(aluno4);
		
		
			
		
		
		
	}
	

}
