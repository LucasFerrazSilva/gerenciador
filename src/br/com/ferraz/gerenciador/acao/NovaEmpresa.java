package br.com.ferraz.gerenciador.acao;

import static br.com.ferraz.gerenciador.acao.AcaoReturnType.REDIRECT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.config.Banco;
import br.com.ferraz.gerenciador.model.Empresa;

public class NovaEmpresa implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String nomeEmpresa = req.getParameter("nome");
		String paramDataAbertura = req.getParameter("dataAbertura");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataAbertura = null;
		
		try {
			dataAbertura = dateFormat.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(0, nomeEmpresa, dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		return new AcaoReturn(REDIRECT, "listaEmpresas");
	}

}
