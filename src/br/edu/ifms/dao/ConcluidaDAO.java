package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifms.modelo.Concluida;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class ConcluidaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Concluida buscarPeloCodigo(Long codigo) {
		return em.find(Concluida.class,codigo);
	}
	
	public void salvar(Concluida concluida) {
		em.merge(concluida);
	}
	//Concluida.buscarConcluidaComResponsaveis
	@SuppressWarnings("unchecked")
	public List<Concluida> buscarTodos(){
		return em.createNamedQuery("Concluida.buscarTodos").getResultList();
	}
	
	@Transactional
	public void excluir(Concluida concluida)throws NegocioException{
		concluida = buscarPeloCodigo(concluida.getCodigo());
		try {
			em.remove(concluida);
			em.flush();
		}catch(PersistenceException e){
			throw new NegocioException("Pesquisa concluida não pode ser excluida.");
		}
		
	}
	
	public Concluida buscarConcluidaComResponsaveis(Long codigo) {
		return em.createNamedQuery("Concluida.buscarConcluidaComResponsaveis",Concluida.class)
				.setParameter("codigo",codigo)
				.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Concluida> buscarComPaginacao(int first,int pageSize){
		return em.createNamedQuery("Concluida.buscarTodos")
				 .setFirstResult(first)
				 .setMaxResults(pageSize)
				 .getResultList();
	}
	
	public Long encontrarQuantidadeDePesquisasConcluidas() {
		return em.createQuery("select count(pc) from Concluida pc",Long.class).getSingleResult();
	}
	

	
}