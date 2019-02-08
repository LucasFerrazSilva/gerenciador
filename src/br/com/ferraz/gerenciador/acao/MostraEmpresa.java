package br.com.ferraz.gerenciador.acao;

import static br.com.ferraz.gerenciador.acao.AcaoReturnType.FORWARD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.config.Banco;
import br.com.ferraz.gerenciador.model.Empresa;

public class MostraEmpresa implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = banco.busca(id);
		
		request.setAttribute("empresa", empresa);
		
		return new AcaoReturn(FORWARD, "formEditaEmpresa.jsp");
	}

}
