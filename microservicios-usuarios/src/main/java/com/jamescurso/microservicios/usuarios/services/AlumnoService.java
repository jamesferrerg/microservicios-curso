package com.jamescurso.microservicios.usuarios.services;

import java.util.List;
import com.jamescurso.microservicios.commons.alumnos.models.entity.Alumno;
import com.jamescurso.microservicios.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno>{
	
	public List<Alumno> findByNombreOrApellido(String term);
	
	public Iterable<Alumno> findAllById(Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
}