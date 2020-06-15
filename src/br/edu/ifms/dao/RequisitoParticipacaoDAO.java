package br.edu.ifms.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.ifms.modelo.RequisitoParticipacao;

public class RequisitoParticipacaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(RequisitoParticipacao requisitoParticipacao) {
		em.persist(requisitoParticipacao);
	}
}
