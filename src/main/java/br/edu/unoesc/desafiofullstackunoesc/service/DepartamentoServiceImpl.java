package br.edu.unoesc.desafiofullstackunoesc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unoesc.desafiofullstackunoesc.dao.DepartamentoDao;
import br.edu.unoesc.desafiofullstackunoesc.domain.Departamento;

@Service
@Transactional(readOnly=false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao dao;
	
	@Override
	public void salvar(Departamento departamento) {
		dao.save(departamento);
		
	}

	@Override
	public void editar(Departamento departamento) {
		dao.update(departamento);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly=true)
	public Departamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly=true)
	public List<Departamento> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
		}
	/*
	 * @Override public boolean departamentoTemCargos(Long id) {
	 * if(buscarPorId(id).getCargos().isEmpty()) { return false; } return true; }
	 */

}