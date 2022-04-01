package br.edu.unoesc.desafiofullstackunoesc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstackunoesc.domain.Beneficio;
import br.edu.unoesc.desafiofullstackunoesc.domain.Usuario;

@Repository
public interface BeneficioRepository extends JpaRepository<Beneficio, Long>{

	/*@Query("select b from BeneficioEntity b "
			+ "inner join UfEntity u ou u."
			+ "where u.email like :search%")
	Page<BeneficioEntity> findByUf(String search);*/
}
