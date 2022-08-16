package br.com.dh.meli.projeto_integrador.repository;

import br.com.dh.meli.projeto_integrador.model.Representant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepresentantRepository extends JpaRepository<Representant,Long> {
}
