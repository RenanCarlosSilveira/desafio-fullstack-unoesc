package br.edu.unoesc.desafiofullstackunoesc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unoesc.desafiofullstackunoesc.dao.BeneficioDao;
import br.edu.unoesc.desafiofullstackunoesc.domain.Beneficio;
import br.edu.unoesc.desafiofullstackunoesc.domain.Departamento;

@Service
@Transactional(readOnly = false)
public class BeneficioServiceImpl implements BeneficioService {

	@Autowired
	private BeneficioDao dao;

	@Override
	public void salvar(Beneficio departamento) {
		dao.save(departamento);

	}

	@Override
	public void editar(Beneficio departamento) {
		dao.update(departamento);

	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Beneficio buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Beneficio> buscarTodos() {
		return dao.findAll();
	}
}
