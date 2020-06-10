package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.edu.ifms.modelo.Pesquisa;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jpa.Transactional;

public class PesquisaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Pesquisa buscarPeloCodigo(Long codigo) {
		return manager.find(Pesquisa.class, codigo);
	}
	
	public void salvar(Pesquisa pesquisa) {
		manager.merge(pesquisa);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pesquisa> buscarTodos(){
		return manager.createQuery("from Pesquisa").getResultList();
	}
	
	@Transactional
	public void excluir(Pesquisa pesquisa) throws NegocioException{
		pesquisa = buscarPeloCodigo(pesquisa.getCodigo());
		try {
			manager.remove(pesquisa);
			manager.flush();
		} catch(PersistenceException e) {
			throw new NegocioException("Este pesquisa não pode ser excluído.");
		}
	}

}
