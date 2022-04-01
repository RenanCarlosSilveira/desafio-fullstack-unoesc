package br.edu.unoesc.desafiofullstackunoesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstackunoesc.domain.Uf;

@Repository
public interface UnidadeFederativaRepository extends JpaRepository<Uf, Long>{

}
