package br.edu.ifms.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evento {
	
	private Long codigo;
	private Concluida concluida;
	private RequisitoParticipacao requisitoParticipacao;
	private Date dataEvento;
	private Date dataInicioInscricao;
	private Date dataTerminoInscricao;
	private BigDecimal valorInscricao;
	private Professor professor;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_requisito_participacao")
	public RequisitoParticipacao getRequisitoParticipacao() {
		return requisitoParticipacao;
	}
	public void setRequisitoParticipacao(RequisitoParticipacao requisitoParticipacao) {
		this.requisitoParticipacao = requisitoParticipacao;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_concluida")
	public Concluida getConcluida() {
		return concluida;
	}
	public void setConcluida(Concluida concluida) {
		this.concluida = concluida;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_professor")
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataInicioInscricao() {
		return dataInicioInscricao;
	}
	public void setDataInicioInscricao(Date dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataTerminoInscricao() {
		return dataTerminoInscricao;
	}
	public void setDataTerminoInscricao(Date dataTerminoInscricao) {
		this.dataTerminoInscricao = dataTerminoInscricao;
	}
	
	
	public BigDecimal getValorInscricao() {
		return valorInscricao;
	}
	public void setValorInscricao(BigDecimal valorInscricao) {
		this.valorInscricao = valorInscricao;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime*result + ((codigo==null)?0:codigo.hashCode());
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
		Evento other = (Evento) obj;
		if(codigo == null) {
			if(other.codigo != null) 
				return false;
		}else if(!codigo.equals(other.codigo))
				return false;
		return true;
	}

}
