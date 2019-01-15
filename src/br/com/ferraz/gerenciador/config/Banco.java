package br.com.ferraz.gerenciador.config;

import java.util.ArrayList;
import java.util.List;

import br.com.ferraz.gerenciador.model.Empresa;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		empresas.add(new Empresa(0, "Alura"));
		empresas.add(new Empresa(1, "Caelum"));
	}

	
	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

}
