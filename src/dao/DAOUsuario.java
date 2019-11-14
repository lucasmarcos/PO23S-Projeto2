package dao;

import conexao.Conexao;
import entidades.Usuario;

public class DAOUsuario {
	private Conexao conexao;

	public DAOUsuario(Conexao conexao) {
		this.conexao = conexao;
	}

	public void inserir(Usuario usuario) {
	}

	public void buscar(int codigo) {
		String sql = "SELECT codigo FROM usuario WHERE codigo = " + codigo + ";";
	}

	public boolean login(String usuario, String senha) {
		String sql = "SELECT codigo FROM usuario WHERE" +
			" email = '" + usuario +
			"' AND senha = '" + senha + "';";

		System.out.println(sql);

		return true;
	}
}
