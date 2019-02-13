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

@WebFilter("/*")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long antes = System.currentTimeMillis();
		
		Acao acao = setAcao((HttpServletRequest) request);
		
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		
		System.out.println("Tempo de execução da Acao " + acao.getClass().getSimpleName() + ": " + (depois - antes));
	}
	
	private Acao setAcao(HttpServletRequest req) throws ServletException {
		try {
			String paramAcao = req.getRequestURI().replace("/gerenciador/", "");
			
			Integer indexOfParam = paramAcao.indexOf('&');
			paramAcao = Character.toUpperCase(paramAcao.charAt(0)) + (indexOfParam > -1 ? paramAcao.substring(1, indexOfParam) : paramAcao.substring(1));
			
			Acao acao = (Acao) Class.forName("br.com.ferraz.gerenciador.acao." + paramAcao).newInstance();
	
			boolean usuarioEstaLogado = req.getSession().getAttribute("usuarioLogado") != null;
			
			acao = (usuarioEstaLogado || !acao.loginObrigatorio() ? acao : new LoginForm());
			
			req.setAttribute("acao", acao);
			
			return acao;
		}
		catch(Exception e) {
			throw new ServletException("Erro ao pegar Acao");
		}
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
}