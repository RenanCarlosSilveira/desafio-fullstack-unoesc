package br.edu.unoesc.desafiofullstackunoesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstackunoesc.domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{

}
