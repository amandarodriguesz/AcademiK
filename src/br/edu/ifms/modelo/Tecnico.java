package br.edu.ifms.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Tecnico extends Pessoa {
	
	private String registroTecnico;

	public String getRegistroTecnico() {
		return registroTecnico;
	}

	public void setRegistroTecnico(String registroTecnico) {
		this.registroTecnico = registroTecnico;
	}
	
	
}
