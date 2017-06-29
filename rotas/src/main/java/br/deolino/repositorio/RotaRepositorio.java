package br.deolino.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.deolino.model.Rota;

public interface RotaRepositorio extends CrudRepository<Rota, Long> {

	List<Rota> findAllByOrderByNameAsc();
}
