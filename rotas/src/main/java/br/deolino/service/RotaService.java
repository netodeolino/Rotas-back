package br.deolino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.deolino.model.Rota;
import br.deolino.repositorio.RotaRepositorio;

@Service
public class RotaService {

	@Autowired
	private RotaRepositorio rotaRepositorio;
	
	public void salvar(Rota rota){
		rotaRepositorio.save(rota);
	}
	
	public void remover(Rota rota){
		rotaRepositorio.delete(rota);
	}
	
	public void atualizar(Rota rota){
		rotaRepositorio.save(rota);
	}
	
	public Rota buscar(Long id){
		return rotaRepositorio.findOne(id);
	}
	
	public List<Rota> listar(){
		return rotaRepositorio.findAllByOrderByNameAsc();
	}
}
