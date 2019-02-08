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

public class EditaEmpresa implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.valueOf(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("dataAbertura");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataAbertura = null;
		
		try {
			dataAbertura = dateFormat.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(id, nomeEmpresa, dataAbertura);
		
		Banco banco = new Banco();
		banco.atualiza(empresa);
		
		return new AcaoReturn(REDIRECT, "listaEmpresas");
	}

}
