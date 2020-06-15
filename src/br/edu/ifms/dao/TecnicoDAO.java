package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifms.modelo.Tecnico;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jpa.Transactional;

public class TecnicoDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Tecnico buscarPeloCodigo(Long codigo) {
		return em.find(Tecnico.class,codigo);
	}
	
	public void salvar(Tecnico tecnico) {
		em.merge(tecnico);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tecnico> buscarTodos(){
		return em.createQuery("from Tecnico").getResultList();
	}
	
	@Transactional
	public void excluir(Tecnico tecnico) throws NegocioException{
		tecnico = buscarPeloCodigo(tecnico.getCodigo());
		try {
			em.remove(tecnico);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Técnico não pode ser excluido!");
		}
	}

}
