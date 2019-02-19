package br.com.ferraz.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

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
		
		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		String xml = xstream.toXML(empresas);
		response.getWriter().print(xml);
		
//		String json = gson.toJson(empresas);
//
//		response.setContentType("application/json");
//		response.getWriter().print(json);
	}

}
