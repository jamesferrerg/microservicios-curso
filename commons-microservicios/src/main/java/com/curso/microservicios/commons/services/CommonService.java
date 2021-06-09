package com.curso.microservicios.commons.services;

import java.util.Optional;

public interface CommonService<E> {
	
	// Para ser mas especifico podria cambiarse Iterable por List
	public Iterable<E> findAll();
	
	public Optional<E> findById(Long id);
	
	public E save(E entity);
	
	public void deleteById(Long id);

}
