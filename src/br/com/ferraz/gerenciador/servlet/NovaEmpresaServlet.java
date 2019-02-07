package br.com.ferraz.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.config.Banco;
import br.com.ferraz.gerenciador.model.Empresa;

//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		resp.sendRedirect("listaEmpresas");
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/listaEmpresas");
//		req.setAttribute("nomeEmpresa", empresa.getNome());
//		dispatcher.forward(req, resp);
	}

}
