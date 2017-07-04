package br.deolino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.deolino.model.Veiculo;
import br.deolino.repositorio.VeiculoRepositorio;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepositorio veiculoRepositorio;
	
	public void salvar(Veiculo veiculo){
		veiculoRepositorio.save(veiculo);
	}
	
	public List<Veiculo> listar(){
		return veiculoRepositorio.findAllByOrderByPlacaAsc();
	}
}
