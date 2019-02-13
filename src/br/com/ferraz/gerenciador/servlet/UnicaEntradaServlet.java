package br.com.ferraz.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.acao.Acao;
import br.com.ferraz.gerenciador.acao.AcaoReturn;

@WebServlet("/")
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Acao acao = (Acao) req.getAttribute("acao");
			
			AcaoReturn acaoReturn = acao.executa(req, resp);

			acaoReturn.executa(req, resp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
