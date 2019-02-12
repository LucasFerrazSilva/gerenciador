package br.com.ferraz.gerenciador.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.ferraz.gerenciador.model.Empresa;
import br.com.ferraz.gerenciador.model.Usuario;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static int idSequencial = 1;
	
	private static List<Usuario> usuarios = new ArrayList<>();
	
	static {
		empresas.add(new Empresa(idSequencial++, "Alura", new Date()));
		empresas.add(new Empresa(idSequencial++, "Caelum", new Date()));

		usuarios.add(new Usuario("lucas", "123"));
		usuarios.add(new Usuario("carina", "456"));
	}

	
	public void adiciona(Empresa empresa) {
		empresa.setId(idSequencial++);
		
		empresas.add(empresa);
	}

	public void atualiza(Empresa empresa) {
		int index = empresas.stream().filter(emp -> emp.getId() == empresa.getId()).map(emp -> empresas.indexOf(emp)).findFirst().get();
		
		empresas.set(index, empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public void remove(int id) {
		Empresa empresa = empresas.stream().filter(emp -> emp.getId() == id).findFirst().get();
		empresas.remove(empresa);
	}

	public Empresa busca(int id) {
		return empresas.stream().filter(empresa -> empresa.getId() == id).findFirst().get();
	}
	
	
	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public boolean usuarioExiste(Usuario usuario) {
		return usuarios.stream().anyMatch(u -> u.ehIgual(usuario));
	}

}
