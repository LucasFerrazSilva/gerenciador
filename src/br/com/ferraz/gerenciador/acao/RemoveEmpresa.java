package br.com.ferraz.gerenciador.acao;

import static br.com.ferraz.gerenciador.acao.AcaoReturnType.REDIRECT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.config.Banco;

public class RemoveEmpresa implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("Removendo empresa");
		
		int id = Integer.valueOf(req.getParameter("id"));
		
		Banco banco = new Banco();
		banco.remove(id);
		
		return new AcaoReturn(REDIRECT, "listaEmpresas");
	}

}
