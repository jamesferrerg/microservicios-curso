package com.jamescurso.microservicios.app.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jamescurso.microservicios.app.cursos.clients.AlumnoFeignClient;
import com.jamescurso.microservicios.app.cursos.clients.RespuestaFeignClient;
import com.jamescurso.microservicios.app.cursos.models.entity.Curso;
import com.jamescurso.microservicios.app.cursos.models.repository.CursoRepository;
import com.jamescurso.microservicios.commons.alumnos.models.entity.Alumno;
import com.jamescurso.microservicios.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Autowired
	private RespuestaFeignClient client;
	
	@Autowired
	private AlumnoFeignClient clientAlumno;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {
		return client.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids) {
		return clientAlumno.obtenerAlumnosPorCurso(ids);
	}

	@Override
	@Transactional
	public void eliminarCursoAlumnoPorId(Long id) {
		repository.eliminarCursoAlumnoPorId(id);
	}

}
