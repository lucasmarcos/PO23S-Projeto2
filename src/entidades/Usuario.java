package entidades;

public class Usuario {
	private int codigo;
	private String nome;
	private String email;
	private String senha;
	private boolean administrador;

	public Usuario() {}

	public Usuario(String nome, String email, String senha, boolean administrador) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.administrador = administrador;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
}
