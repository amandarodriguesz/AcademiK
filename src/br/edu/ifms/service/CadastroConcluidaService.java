package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.ConcluidaDAO;
import br.edu.ifms.modelo.Concluida;
import br.edu.ifms.util.jpa.Transactional;

public class CadastroConcluidaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ConcluidaDAO concluidaDAO;
	
	@Transactional
	public void salvar(Concluida concluida)throws NegocioException{
		if(concluida.getResumoPesquisa()==null || concluida.getResumoPesquisa().trim().equals("")) {
			throw new NegocioException("O resumo da pesquisa é obrigatório");
		}
		
		this.concluidaDAO.salvar(concluida);
	}

}
