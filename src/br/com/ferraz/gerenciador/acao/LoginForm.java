package br.com.ferraz.gerenciador.acao;

import static br.com.ferraz.gerenciador.acao.AcaoReturnType.FORWARD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return new AcaoReturn(FORWARD, "formLogin.jsp");
	}

}
