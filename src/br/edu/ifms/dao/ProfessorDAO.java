package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifms.modelo.Professor;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jpa.Transactional;

public class ProfessorDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Professor buscarPeloCodigo(Long codigo) {
		return em.find(Professor.class, codigo);
	}
	
	public void salvar(Professor professor) {
		em.merge(professor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> buscarTodos(){
		return em.createQuery("from Professor").getResultList();
	}
	
	@Transactional
	public void excluir(Professor professor) throws NegocioException{
		professor = buscarPeloCodigo(professor.getCodigo());
		try {
			em.remove(professor);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Professor não pode ser excluido!");
		}
	}
	
}
