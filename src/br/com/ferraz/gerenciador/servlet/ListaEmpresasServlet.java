package br.com.ferraz.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.config.Banco;
import br.com.ferraz.gerenciador.model.Empresa;

//@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		
		List<Empresa> empresas = banco.getEmpresas();
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("listaEmpresas.jsp");
		req.setAttribute("empresas", empresas);
		dispatcher.forward(req, resp);		
	}

}
