package br.edu.ifms.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name="Concluida.buscarTodos",query="select c from Concluida c"),
	@NamedQuery(name="Concluida.buscarConcluidaComResponsaveis",query="select c "
			     + " from Concluida c JOIN c.responsaveisPesquisas rp "
			     + " where c.codigo = :codigo")
})
public class Concluida {
		private Long codigo;
		private String resumoPesquisa;
		private BigDecimal valorDisponivelParaInscricao;
		private List<ResponsavelPesquisa> responsaveisPesquisas;
		private Pesquisa pesquisa; 
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public Long getCodigo() {
			return codigo;
		}
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		public String getResumoPesquisa() {
			return resumoPesquisa;
		}
		public void setResumoPesquisa(String resumoPesquisa) {
			this.resumoPesquisa = resumoPesquisa;  
		}
		public BigDecimal getValorDisponivelParaInscricao() {
			return valorDisponivelParaInscricao;
		}
		public void setValorDisponivelParaInscricao(BigDecimal valorDisponivelParaInscricao) {
			this.valorDisponivelParaInscricao = valorDisponivelParaInscricao;
		}
		
		@ManyToOne
		@JoinColumn(name="codigo_pesquisa")
		public Pesquisa getPesquisa() {
			return pesquisa;
		}
		
		public void setPesquisa(Pesquisa pesquisa) {
			this.pesquisa = pesquisa;
		}
		
		@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
		@JoinTable(name="concluida_responsaveis"
				,joinColumns = @JoinColumn(name="codigo_pesquisa")
				,inverseJoinColumns = @JoinColumn(name="codigo_responsavel"))
		public List<ResponsavelPesquisa> getResponsaveisPesquisas(){
			return responsaveisPesquisas;
		}
		public void setResponsaveisPesquisas(List<ResponsavelPesquisa> responsaveis) {
			this.responsaveisPesquisas = responsaveis;
		}

		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result=1;
			result = prime*result+((codigo==null)? 0:codigo.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this==obj) return true;
			if(obj==null) return false;
			if(getClass() != obj.getClass()) return false;
			
		Concluida other = (Concluida) obj;
			if(codigo==null) {
				if(other.codigo != null)
					return false;
			}else if(!codigo.equals(other.codigo))
				return false;
			return true;
		}
}


		

