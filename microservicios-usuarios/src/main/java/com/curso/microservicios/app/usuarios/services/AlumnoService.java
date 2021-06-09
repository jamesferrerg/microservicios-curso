package com.curso.microservicios.app.usuarios.services;

import java.util.List;

import com.curso.microservicios.commons.alumnos.models.entity.Alumno;
import com.curso.microservicios.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno> {
	
	public List<Alumno> findByNombrOrApellido(String term);
}
