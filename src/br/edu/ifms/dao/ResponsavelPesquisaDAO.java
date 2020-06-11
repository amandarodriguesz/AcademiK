package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import br.edu.ifms.modelo.ResponsavelPesquisa;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class ResponsavelPesquisaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(ResponsavelPesquisa responsavelPelaPesquisa) {
		em.merge(responsavelPelaPesquisa);
	}
	
	@SuppressWarnings("unchecked")
	public List<ResponsavelPesquisa> buscarTodos(){
		return em.createQuery("from ResponsavelPesquisa").getResultList();
	}
	
	@Transactional
	public void excluir(ResponsavelPesquisa responsavelPelaPesquisa)throws NegocioException{
		ResponsavelPesquisa responsavelPelaPesquisaTemp = em.find(ResponsavelPesquisa.class, responsavelPelaPesquisa.getCodigo());
		try {
		em.remove(responsavelPelaPesquisaTemp);
		em.flush();
		}catch(PersistenceException e) {
			throw new NegocioException("Responsável pela pesquisa não pode ser excluido.");
		}
	}
	
	public ResponsavelPesquisa buscarPeloCodigo(Long codigo) {
		return em.find(ResponsavelPesquisa.class, codigo);
	}
	
}