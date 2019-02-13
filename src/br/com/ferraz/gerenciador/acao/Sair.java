package br.com.ferraz.gerenciador.acao;

import static br.com.ferraz.gerenciador.acao.AcaoReturnType.REDIRECT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sair implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getSession().invalidate();
		
		return new AcaoReturn(REDIRECT, "loginForm");
	}

	@Override
	public boolean loginObrigatorio() {
		return false;
	}

}
