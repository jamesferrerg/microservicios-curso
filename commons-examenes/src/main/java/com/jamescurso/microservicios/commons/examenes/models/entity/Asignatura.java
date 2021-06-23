package com.jamescurso.microservicios.commons.examenes.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "asignaturas")
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	/* 
	JsonIgnoreProperties: se utiliza esto para evitar llamar el padre al hijo y
	viceverse convirtiendose en un loop infinito (llamandose a si misma una y
	otra vez). Para evitar este llamado se usa la propiedad
	"JsonIgnoreProperties"
	*/
	@JsonIgnoreProperties(value = {"hijos", "handler", "hibernateLazyInitializer"})
	//Muchos elementos hijos pueden estar asignados al padre 
	@ManyToOne(fetch = FetchType.LAZY)
	private Asignatura padre;

	@JsonIgnoreProperties(value = {"padre", "handler", "hibernateLazyInitializer"}, allowSetters = true)
	// Una asignatura muchos hijos
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "padre", cascade = CascadeType.ALL)
	private List<Asignatura> hijos;
	
	public Asignatura() {
		this.hijos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Asignatura getPadre() {
		return padre;
	}

	public void setPadre(Asignatura padre) {
		this.padre = padre;
	}

	public List<Asignatura> getHijos() {
		return hijos;
	}

	public void setHijos(List<Asignatura> hijos) {
		this.hijos = hijos;
	}
	
}
