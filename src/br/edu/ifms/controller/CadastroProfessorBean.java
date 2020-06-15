package br.edu.ifms.controller;

import java.io.Serializable;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifms.modelo.Professor;
import br.edu.ifms.modelo.Sexo;
import br.edu.ifms.service.CadastroProfessorService;
import br.edu.ifms.service.NegocioException;
import br.edu.ifms.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProfessorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Professor professor;
	
	@Inject
	private CadastroProfessorService cadastroProfessorService;
	
	private List<Sexo> sexos;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.sexos=Arrays.asList(Sexo.values());
	}
	
	public void salvar() {
		try {
			this.cadastroProfessorService.salvar(professor);
			FacesUtil.addSuccessMessage("Professor Cadastrado com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}
	
	public void limpar() {
		this.professor = new Professor();
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Sexo> getSexos(){
		return sexos;
	}
	
	}
