package br.edu.ifms.controller;

import java.io.Serializable;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.modelo.Tecnico;
import br.edu.ifms.modelo.Sexo;
import br.edu.ifms.service.CadastroTecnicoService;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroTecnicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Tecnico tecnico;
	
	@Inject
	private CadastroTecnicoService cadastroTecnicoService;
	
	private List<Sexo> sexos;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.sexos=Arrays.asList(Sexo.values());
	}
	
	public void salvar() {
		try {
			this.cadastroTecnicoService.salvar(tecnico);
			FacesUtil.addSuccessMessage("Tecnico Cadastrado com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}
	
	public void limpar() {
		this.tecnico = new Tecnico();
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}
	
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	public List<Sexo> getSexos(){
		return sexos;
	}
	
	}
