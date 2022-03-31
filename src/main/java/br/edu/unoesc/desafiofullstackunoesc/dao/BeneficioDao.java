package br.edu.unoesc.desafiofullstackunoesc.dao;

import java.util.List;

import br.edu.unoesc.desafiofullstackunoesc.domain.Beneficio;
import br.edu.unoesc.desafiofullstackunoesc.domain.Departamento;

public interface BeneficioDao {
	void save (Beneficio beneficio);
	
	void update(Beneficio beneficio);
	
	void delete(Long id);
	
	Beneficio findById(Long id);
	
	List<Beneficio> findAll();
}
