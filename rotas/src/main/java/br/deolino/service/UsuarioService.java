package br.deolino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.deolino.config.TokenAuthenticationService;
import br.deolino.model.Usuario;
import br.deolino.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private TokenAuthenticationService serviceToken;
	
	public String login(String login, String senha) throws Exception{
		
		Usuario loginUsuario = usuarioRepositorio.findByLoginAndSenha(login, senha);

		if(loginUsuario != null){	
			return serviceToken.newAuthentication(login);
		}
		throw new Exception();
	}
	
	public boolean salvar(Usuario usuario){
		usuarioRepositorio.save(usuario);
		return true;
	}
}
