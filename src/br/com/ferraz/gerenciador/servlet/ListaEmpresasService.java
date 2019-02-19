package br.com.ferraz.gerenciador.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.ferraz.gerenciador.config.Banco;
import br.com.ferraz.gerenciador.model.Empresa;

@WebServlet("/empresas")
public class ListaEmpresasService extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		Gson gson = new Gson();
		
		List<Empresa> empresas = banco.getEmpresas();
		
		String contentType = Optional.ofNullable(request.getHeader("Accept")).orElse("");
		
		System.out.println(contentType);
		
		response.setContentType(contentType);
		
		String message = null;
		
		if(contentType.contains("application/json")) {
			message = gson.toJson(empresas);			
		}
		else if(contentType.contains("application/xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			
			message = xstream.toXML(empresas);
		}
		else {
			response.setContentType("application/json");
			message = "{'message': 'no content'}";			
		}
		
		response.getWriter().print(message);	
	}

}
