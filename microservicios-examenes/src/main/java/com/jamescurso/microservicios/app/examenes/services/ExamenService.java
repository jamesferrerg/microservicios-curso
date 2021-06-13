package com.jamescurso.microservicios.app.examenes.services;

import java.util.List;

import com.jamescurso.microservicios.commons.examenes.models.entity.Asignatura;
import com.jamescurso.microservicios.commons.examenes.models.entity.Examen;
import com.jamescurso.microservicios.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen>{
	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();
}
