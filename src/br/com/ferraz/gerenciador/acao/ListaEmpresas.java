package br.com.ferraz.gerenciador.acao;

import static br.com.ferraz.gerenciador.acao.AcaoReturnType.FORWARD;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.config.Banco;
import br.com.ferraz.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Banco banco = new Banco();
		
		List<Empresa> empresas = banco.getEmpresas();
		
		req.setAttribute("empresas", empresas);
		
		return new AcaoReturn(FORWARD, "listaEmpresas.jsp");
	}

}
