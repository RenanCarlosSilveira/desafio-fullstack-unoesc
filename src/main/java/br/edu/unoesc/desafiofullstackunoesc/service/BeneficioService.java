package br.edu.unoesc.desafiofullstackunoesc.service;

import java.util.List;

import br.edu.unoesc.desafiofullstackunoesc.domain.Beneficio;
import br.edu.unoesc.desafiofullstackunoesc.domain.Departamento;


public interface BeneficioService {
	void salvar(Beneficio beneficio);
	
	void editar(Beneficio beneficio);
	
	void excluir(Long id);
	
	Beneficio buscarPorId(Long id);
	
	List<Beneficio> buscarTodos(); 
}
