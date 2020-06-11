package br.edu.ifms.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PesquisaConcluida {
		private Long codigo;
		private String resumoPesquisa;
		private BigDecimal valorDisponivelParaInscricao;
		
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
			
			PesquisaConcluida other = (PesquisaConcluida) obj;
			if(codigo==null) {
				if(other.codigo != null)
					return false;
			}else if(!codigo.equals(other.codigo))
				return false;
			return true;
		}
}


		

