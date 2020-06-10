package br.edu.ifms.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifms.dao.PesquisaDAO;
import br.edu.ifms.modelo.Pesquisa;
import br.edu.ifms.util.jpa.Transactional;

public class CadastroPesquisaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	PesquisaDAO pesquisaDAO;
	
	@Transactional
	public void salvar(Pesquisa pesquisa) throws NegocioException {
		if(pesquisa.getNome() == null || 
				pesquisa.getNome().trim().equals("")) {
					throw new NegocioException("O nome da pesquisa é obrigatório");
		}
		
		if(pesquisa.getAluno() == null) {
			throw new NegocioException("Informar o aluno é obrigatório");
		}
		
		this.pesquisaDAO.salvar(pesquisa);
	}
}
