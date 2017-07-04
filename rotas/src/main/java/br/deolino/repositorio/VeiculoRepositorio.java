package br.deolino.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.deolino.model.Veiculo;

public interface VeiculoRepositorio extends CrudRepository<Veiculo, Long> {

	List<Veiculo> findAllByOrderByPlacaAsc();
}
