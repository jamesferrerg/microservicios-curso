package com.curso.microservicios.app.examenes.services;

import java.util.List;

import com.curso.microservicios.commons.examenes.models.entity.Asignatura;
import com.curso.microservicios.commons.examenes.models.entity.Examen;
import com.curso.microservicios.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen>{
	
	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();
}
