package org.formacio.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServeiAlumnat {

	@Autowired
	RepositoriAlumnesMemoria repo;
	/**
	 * ha de donar d'alta a la base de dades d'alumnes l'alumne indicat amb 
	 * el corresponent codi.
	 * Si el nom de l'alumne es null, no l'ha de donar d'alta
	 * Retorna true si l'alumne s'ha inserit, false si no.
	 */
	public boolean matricula (int id, String alumne) {
		if (alumne != null) {
			repo.altaAlumne(id, alumne);
			return true;
		}
		else {
			return false;
		}
	}
	
	// Inicializar la base de datos con los dos alumnos: "Antonia" y "Joan"
	@PostConstruct
	public void init() {
		String[] alumnos = { "Antonia", "Joan" };
		int posicion = 1;
		
		for (String alumne : alumnos) {
			repo.altaAlumne(posicion, alumne);
			posicion += 1;
		}
	}
}
