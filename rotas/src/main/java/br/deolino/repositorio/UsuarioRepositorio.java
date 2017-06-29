package br.deolino.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.deolino.model.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
	
	Usuario findByLoginAndSenha(String login, String senha);
	
	Usuario findByLogin(String login);
}
