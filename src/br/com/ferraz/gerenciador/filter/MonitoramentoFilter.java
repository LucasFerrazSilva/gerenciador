package br.com.ferraz.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="MonitoramentoFilter")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MonitoramentoFilter");

		long antes = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		
		System.out.println("Tempo de execu��o da Acao " + request.getAttribute("acao").getClass().getSimpleName() + ": " + (depois - antes));
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
}