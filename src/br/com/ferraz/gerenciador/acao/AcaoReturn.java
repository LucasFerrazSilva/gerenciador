package br.com.ferraz.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcaoReturn {

	private AcaoReturnType returnType;
	private String jspNameOrUrl;
	
	
	public AcaoReturn(AcaoReturnType returnType, String jspNameOrUrl) {
		this.returnType = returnType;
		this.jspNameOrUrl = jspNameOrUrl;
	}
	
	
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		returnType.executa(req, resp, jspNameOrUrl);
	}
	
}
