package br.deolino.config;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.deolino.model.Permissao;

@Service
public class TokenAuthenticationService {

	private final long TIMEEXPIRE = (12 * 60 * 60 * 1000);
	private final String SECRET = "trixlog";
	private final String TOKEN_PREFIX = "Bearer ";
	private final String HEADER_STRING = "Authorization";
	private final String WITHISSUER = "TRIXLOG";
	
	public String newAuthentication(String username) throws IllegalArgumentException, UnsupportedEncodingException {

		Algorithm algorithm = Algorithm.HMAC512(SECRET);
		String token = JWT.create()
				.withIssuer(WITHISSUER)
				.withSubject(username)
				.withExpiresAt(new Date(System.currentTimeMillis() + TIMEEXPIRE))
				.sign(algorithm);

		return token;
	}

	public Authentication getAuthentication(HttpServletRequest request) throws ServletException {
		String token = request.getHeader(HEADER_STRING);
		List<Permissao> lista = new ArrayList<>();
		if (token != null) {
			Algorithm algorithm;
			try {
				algorithm = Algorithm.HMAC512(SECRET);

				JWTVerifier verifier = JWT.require(algorithm)
						.withIssuer(WITHISSUER)
						.acceptLeeway(1)
						.acceptExpiresAt(5)
						.build();

				DecodedJWT jwt = verifier.verify(token.replace(TOKEN_PREFIX, ""));

				String user = jwt.getSubject();

				if(user!=null){
					lista.add(Permissao.ADM);
					return new UsernamePasswordAuthenticationToken(user, null, lista);
				}
			} catch (Exception e) {

			}
		}
		return new UsernamePasswordAuthenticationToken(null, null, lista);
	}
}
