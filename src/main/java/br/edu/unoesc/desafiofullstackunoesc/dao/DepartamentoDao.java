package br.edu.unoesc.desafiofullstackunoesc.dao;

import java.util.List;

import br.edu.unoesc.desafiofullstackunoesc.domain.Departamento;

public interface DepartamentoDao {
	void save (Departamento departamento);
	
	void update(Departamento departamento);
	
	void delete(Long id);
	
	Departamento findById(Long id);
	
	List<Departamento> findAll();
}
