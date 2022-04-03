package br.edu.unoesc.desafiofullstackunoesc.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.unoesc.desafiofullstackunoesc.dao.BeneficioDao;
import br.edu.unoesc.desafiofullstackunoesc.dao.BeneficioDaoImpl;
import br.edu.unoesc.desafiofullstackunoesc.domain.Beneficio;

@Service
@Transactional(readOnly = false)
public class BeneficioServiceImpl implements BeneficioService {

	@Value("${chave.api}")
	String chaveapi;

	@Autowired
	private BeneficioDao dao;

	@Autowired
	private BeneficioDaoImpl repository;

	@Transactional(readOnly = true)
	public List<Beneficio> buscartodos() {
		return repository.findAll();
	}

	@Override
	public void salvar(Beneficio beneficio) {
		dao.save(beneficio);

	}

	@Override
	public void editar(Beneficio beneficio) {
		dao.update(beneficio);

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

	@Override
	@Transactional(readOnly = false)
	public Beneficio[] buscaBeneficios(String codibge, String anoref, String mesref, String pag) throws Exception {
		URL url = new URL(
				"https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge="
						+ codibge + "&mesAno=" + anoref + mesref + "&pagina=" + pag);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("chave-api-dados", chaveapi);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		Beneficio[] ben_beneficiario = new ObjectMapper().readValue(buffer, Beneficio[].class);
		connection.disconnect();
		return ben_beneficiario;
	}

	@Override
	@Transactional(readOnly = false)
	public void salvaBeneficios(String codibge, String anoref, String mesref, String pag) throws Exception {
		URL url = new URL(
				"https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge="
						+ codibge + "&mesAno=" + anoref + mesref + "&pagina=" + pag);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("chave-api-dados", chaveapi);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		Beneficio[] ben_beneficiario = new ObjectMapper().readValue(buffer, Beneficio[].class);
		connection.disconnect();
		for (int i = 0; i < ben_beneficiario.length; i++) {
			ben_beneficiario[i].setDataconsulta(LocalDateTime.now());
			salvar(ben_beneficiario[i]);
			System.out.println(LocalDateTime.now());
		}
	}

	public byte[] exportaCSV(String codibge, String anoref, String mesref, String pag) throws Exception {
		URL url = new URL(
				"https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge="
						+ codibge + "&mesAno=" + anoref + mesref + "&pagina=" + pag);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("chave-api-dados", chaveapi);
		connection.disconnect();
		InputStream is = connection.getInputStream();
		JSONTokener tokener = new JSONTokener(Objects.requireNonNull(is));
		JSONArray jsonArray = new JSONArray(tokener);
		String csv = CDL.toString(jsonArray);
		return csv.getBytes();
	}

}
