package br.com.ferraz.gerenciador.model;

public class Usuario {

	private String login;
	private String senha;

	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	

	public boolean ehIgual(Usuario user) {
		return ehIgual(user.getLogin(), user.getSenha());
	}
	
    public boolean ehIgual(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
	
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }	
	
}
