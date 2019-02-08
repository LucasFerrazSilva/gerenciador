package br.com.ferraz.gerenciador.acao;

import static br.com.ferraz.gerenciador.acao.AcaoReturnType.FORWARD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormNovaEmpresa implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new AcaoReturn(FORWARD, "formNovaEmpresa.jsp");
	}

}
