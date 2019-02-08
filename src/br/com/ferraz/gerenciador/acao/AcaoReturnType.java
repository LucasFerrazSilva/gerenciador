package br.com.ferraz.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public enum AcaoReturnType {

	FORWARD {		
		public void executa(HttpServletRequest req, HttpServletResponse resp, String jspName) throws Exception {
			req.getRequestDispatcher("WEB-INF/views/" + jspName).forward(req, resp);
		}
		
	},
	REDIRECT {
		public void executa(HttpServletRequest req, HttpServletResponse resp, String url) throws Exception {
			resp.sendRedirect(url);
		}		
	};
	
	
	public abstract void executa(HttpServletRequest req, HttpServletResponse resp, String url) throws Exception ;
	
}
