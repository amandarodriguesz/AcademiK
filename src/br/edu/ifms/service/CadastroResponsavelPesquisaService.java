package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.ResponsavelPesquisaDAO;
import br.edu.ifms.modelo.ResponsavelPesquisa;
import br.edu.ifms.util.jpa.Transactional;

public class CadastroResponsavelPesquisaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResponsavelPesquisaDAO responsavelPesquisaDAO;
	
	@Transactional
	public void salvar(ResponsavelPesquisa responsavelPesquisa)throws NegocioException{
		if(responsavelPesquisa.getNomeCompleto()==null || responsavelPesquisa.getNomeCompleto().trim().equals("")) {
			throw new NegocioException("O nome do responsável pela pesquisa é obrigatório");
		}
		
		this.responsavelPesquisaDAO.salvar(responsavelPesquisa);
	}

}
