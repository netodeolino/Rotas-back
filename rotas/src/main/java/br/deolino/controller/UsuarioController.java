package br.deolino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.deolino.model.Usuario;
import br.deolino.service.UsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Usuario usuario){
		try{
			return new ResponseEntity<String>(usuarioService.login(usuario.getLogin(), usuario.getSenha()), HttpStatus.OK);
		}catch(Exception e){
			//e.printStackTrace();
			return new ResponseEntity<String>("Login e/ou senha inválido(s)", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/salvar")
	public String salvar(@RequestBody Usuario usuario){
		this.usuarioService.salvar(usuario);
		return "sucesso";
	}
}
