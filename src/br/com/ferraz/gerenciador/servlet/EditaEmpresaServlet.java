package br.com.ferraz.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.config.Banco;
import br.com.ferraz.gerenciador.model.Empresa;

//@WebServlet("/editaEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = banco.busca(id);
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/formEditaEmpresa.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		response.sendRedirect("listaEmpresas");
	}

}
