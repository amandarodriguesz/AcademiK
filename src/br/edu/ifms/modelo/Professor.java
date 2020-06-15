package br.edu.ifms.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Professor extends Pessoa {
	private String matriculaProfessor;

	public String getMatriculaProfessor() {
		return matriculaProfessor;
	}

	public void setMatriculaProfessor(String matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}
	
	
}
