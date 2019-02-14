package br.com.ferraz.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.ferraz.gerenciador.acao.Acao;
import br.com.ferraz.gerenciador.acao.LoginForm;

@WebFilter(filterName="ValidaLoginFilter", urlPatterns="/*")
public class ValidaLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ValidaLogginFilter");

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			
			Acao acao = (Acao) req.getAttribute("acao");
	
			boolean usuarioEstaLogado = req.getSession().getAttribute("usuarioLogado") != null;
			
			acao = (usuarioEstaLogado || !acao.loginObrigatorio() ? acao : new LoginForm());
			
			req.setAttribute("acao", acao);
			
			chain.doFilter(request, response);
		}
		catch(Exception e) {
			throw new ServletException("Erro ao validar loggin!\n" + e);
		}
	}
	

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

}
