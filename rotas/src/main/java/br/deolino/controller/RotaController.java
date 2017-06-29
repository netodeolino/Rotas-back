package br.deolino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.deolino.model.Rota;
import br.deolino.service.RotaService;

@RestController
@RequestMapping(value="/rota")
public class RotaController {

	@Autowired
	RotaService rotaService;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@RequestBody Rota rota){
		rotaService.salvar(rota);
		return "sucesso";
	}
	
	@RequestMapping(value = "/remover", method = RequestMethod.POST)
	public String remover(@RequestBody Rota rota){
		rotaService.remover(rota);
		return "sucesso";
	}
	
	@RequestMapping(value = "/atualizar", method = RequestMethod.POST)
	public String atualizar(@RequestBody Rota rota){
		rotaService.atualizar(rota);
		return "sucesso";
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Rota> listar(){
		return rotaService.listar();
	}
	
}
