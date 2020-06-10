package br.edu.ifms.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import br.edu.ifms.enums.TipoPesquisa;

@Entity
public class Pesquisa {
	private Long codigo;
	private String nome;
	private String orientador;
	private Aluno aluno;
	private TipoPesquisa tipo;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ManyToOne
	@JoinColumn(name = "codigo_aluno")
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Enumerated(EnumType.STRING)
	public TipoPesquisa getTipo() {
		return tipo;
	}
	public void setTipo(TipoPesquisa tipo) {
		this.tipo = tipo;
	}
	public String getOrientador() {
		return orientador;
	}
	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Pesquisa other = (Pesquisa) obj;
		if(codigo == null) {
			if(other.codigo != null) 
				return false;
		}else if(!codigo.equals(other.codigo))
				return false;
		return true;
		}
	
}
