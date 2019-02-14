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

@WebFilter(filterName="SetAcaoFilter")
public class SetAcaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SetAcaoFilter");
		
		String paramAcao = null;
			
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			
			paramAcao = req.getRequestURI().replace("/gerenciador/", "");
			
			Integer indexOfParam = paramAcao.indexOf('&');
			paramAcao = Character.toUpperCase(paramAcao.charAt(0)) + (indexOfParam > -1 ? paramAcao.substring(1, indexOfParam) : paramAcao.substring(1));
			
			Acao acao = (Acao) Class.forName("br.com.ferraz.gerenciador.acao." + paramAcao).newInstance();
	
			req.setAttribute("acao", acao);
			
			chain.doFilter(request, response);
		}
		catch(Exception e) {
			throw new ServletException("Erro ao pegar acao " + paramAcao + "\n" + e);
		}
	}
	

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

}
