package br.com.ferraz.gerenciador.acao;

import static br.com.ferraz.gerenciador.acao.AcaoReturnType.REDIRECT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ferraz.gerenciador.config.Banco;
import br.com.ferraz.gerenciador.model.Usuario;

public class Login implements Acao {

	@Override
	public AcaoReturn executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usuario = new Usuario(login, senha);
		
		Banco banco = new Banco();
		
		if(banco.usuarioExiste(usuario)) {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			return new AcaoReturn(REDIRECT, "listaEmpresas");
		}
		else {
			return new AcaoReturn(REDIRECT, "loginForm");
		}		
	}

	@Override
	public boolean loginObrigatorio() {
		return false;
	}

}
