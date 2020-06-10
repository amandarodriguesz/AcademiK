package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import br.edu.ifms.modelo.Aluno;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jpa.Transactional;

import javax.persistence.EntityManager;

public class AlunoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Aluno aluno) {
		em.merge(aluno);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> buscarTodos(){
		return em.createQuery("from Aluno").getResultList();
	}
	
	@Transactional
	public void excluir(Aluno aluno)throws NegocioException{
		Aluno alunoTemp = em.find(Aluno.class, aluno.getCodigo());
		
		em.remove(alunoTemp);
		em.flush();
	}
	
	public Aluno buscarPeloCodigo(Long codigo) {
		return em.find(Aluno.class, codigo);
	}
	
}