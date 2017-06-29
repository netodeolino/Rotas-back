package br.deolino.model;

import org.springframework.security.core.GrantedAuthority;

public enum Permissao implements GrantedAuthority {

	ADM;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
