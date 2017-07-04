package br.deolino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.deolino.model.Veiculo;
import br.deolino.service.VeiculoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/veiculo")
public class VeiculoController {

	@Autowired
	VeiculoService veiculoService;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@RequestBody Veiculo veiculo){
		veiculoService.salvar(veiculo);
		return "sucesso";
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Veiculo> listar(){
		return veiculoService.listar();
	}
}
