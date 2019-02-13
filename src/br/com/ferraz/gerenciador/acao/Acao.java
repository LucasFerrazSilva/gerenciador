package br.com.ferraz.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {

	public AcaoReturn executa(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	
	public default boolean loginObrigatorio() {
		return true;
	}
	
}
