package br.edu.unoesc.desafiofullstackunoesc.service;

import java.util.List;

import br.edu.unoesc.desafiofullstackunoesc.domain.Beneficio;

public interface BeneficioService {
	void salvar(Beneficio beneficio);

	void editar(Beneficio beneficio);

	void excluir(Long id);

	Beneficio buscarPorId(Long id);

	List<Beneficio> buscarTodos();

	Beneficio[] buscaBeneficios(String codibge, String anoref, String mesref, String pag) throws Exception;

	void salvaBeneficios(String codibge, String anoref, String mesref, String pag) throws Exception;

	public byte[] exportaCSV(String codibge, String anoref, String mesref, String pag) throws Exception;

}
