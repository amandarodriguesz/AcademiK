package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.edu.ifms.modelo.Evento;



public class EventoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EntityManager em;
	
	public void salvar(Evento evento) {
		em.merge(evento);
	}
	
		
	public List<Evento> buscarPorDataDoEventoEPesquisa(Date dataEvento){
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Evento> criteriaQuery = builder.createQuery(Evento.class);
		Root<Evento> a = criteriaQuery.from(Evento.class);
		criteriaQuery.select(a);
	
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(dataEvento!=null) {
			predicates.add(builder.lessThanOrEqualTo(a.<Date>get("dataEvento"), dataEvento));
		}
		

		
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Evento> query = em.createQuery(criteriaQuery);
		

		
		return query.getResultList();
	}

	
}

