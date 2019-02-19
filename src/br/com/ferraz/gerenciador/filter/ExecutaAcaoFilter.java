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
import javax.servlet.http.HttpServletResponse;

import br.com.ferraz.gerenciador.acao.Acao;
import br.com.ferraz.gerenciador.acao.AcaoReturn;

@WebFilter(filterName="ExecutaAcaoFilter")
public class ExecutaAcaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ExecutaAcaoFilter");

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
			Acao acao = (Acao) req.getAttribute("acao");
			
			if(acao != null) {
				AcaoReturn acaoReturn = acao.executa(req, resp);
	
				acaoReturn.executa(req, resp);
			}
			else {
				chain.doFilter(request, response);
			}
		} 
		catch (Exception e) {
			System.out.println("Erro ao executar acao\n" + e);
		}
	}
	

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	
}
