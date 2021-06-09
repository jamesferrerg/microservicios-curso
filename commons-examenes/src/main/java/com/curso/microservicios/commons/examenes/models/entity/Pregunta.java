package com.curso.microservicios.commons.examenes.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "preguntas")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String texto;
	
	@JsonIgnoreProperties(value = {"preguntas"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="examen_id")
	private Examen examen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	// esto se realiza cuando se desea eliminar un objeto
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			//lo encuentra y lo elimina
			return true;
		}
		
		// si no es una instancia de alumno retorna falso y si lo es comapra los ids
		if (!(obj instanceof Pregunta)) {
			return false;
		}
		
		Pregunta a = (Pregunta) obj;
		 //busca y elimina un objeto de la relacion (busca en curso y elimina un alumno)
		return this.id != null && this.id.equals(a.getId());
	}
	
	
}
