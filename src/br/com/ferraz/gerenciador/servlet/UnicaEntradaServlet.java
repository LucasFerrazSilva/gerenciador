package br.com.ferraz.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.acao.Acao;
import br.com.ferraz.gerenciador.acao.AcaoReturn;
import br.com.ferraz.gerenciador.acao.Login;
import br.com.ferraz.gerenciador.acao.LoginForm;

@WebServlet("/")
public class UnicaEntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Acao acao = getAcao(req);
			
			AcaoReturn acaoReturn = acao.executa(req, resp);

			acaoReturn.executa(req, resp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	private Acao getAcao(HttpServletRequest req) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String paramAcao = req.getRequestURI().replace("/gerenciador/", "");
		
		Integer indexOfParam = paramAcao.indexOf('&');
		paramAcao = Character.toUpperCase(paramAcao.charAt(0)) + (indexOfParam > -1 ? paramAcao.substring(1, indexOfParam) : paramAcao.substring(1));
		
		Acao acao = (Acao) Class.forName("br.com.ferraz.gerenciador.acao." + paramAcao).newInstance();
		
		return (podeAcessarAcao(req, acao) ? acao : new LoginForm());
	}


	private boolean podeAcessarAcao(HttpServletRequest req, Acao acao) {
		boolean usuarioEstaLogado = req.getSession().getAttribute("usuarioLogado") != null;
		
		return usuarioEstaLogado || acao.getClass().isAssignableFrom(Login.class);
	}

}
