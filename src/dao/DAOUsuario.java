package dao;

import conexao.Conexao;
import entidades.Usuario;
import java.sql.ResultSet;

public class DAOUsuario {
	private Conexao conexao;

	public DAOUsuario(Conexao conexao) {
		this.conexao = conexao;
	}

	public void inserir(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome, email, senha, administrador) VALUES ('" +
			usuario.getNome() + "', '" +
			usuario.getEmail() + "', '" +
			usuario.getSenha() + "', " +
			usuario.getAdministrador() + ");";

		conexao.executarSQL(sql);
	}

	public Usuario buscar(int codigo) {
		Usuario usuario = new Usuario();
		String sql = "SELECT codigo, nome, email, senha, administrador FROM usuario WHERE codigo = " + codigo + ";";

		ResultSet rs = conexao.buscar(sql);
		try {
			rs.next();
			usuario.setCodigo(rs.getInt("codigo"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setAdministrador(rs.getBoolean("administrador"));
		} catch(Exception e) {
			System.out.println("Erro ao buscar usuario: " + e.getMessage());
		}

		return usuario;
	}

	public void remover(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE codigo = " + usuario.getCodigo() + ";";
		conexao.executarSQL(sql);
	}

	public Usuario login(String email, String senha) {
		String sql = "SELECT codigo FROM usuario WHERE" +
			" email = '" + email +
			"' AND senha = '" + senha + "';";

		ResultSet rs = conexao.buscar(sql);
		try {
			rs.next();
			int codigo = rs.getInt("codigo");
			return buscar(codigo);
		} catch(Exception e) {
			return null;
		}
	}

	public boolean primeiroLogin() {
		String sql = "SELECT COUNT(codigo) FROM usuario WHERE administrador = true;";
		ResultSet rs = conexao.buscar(sql);
		int usuarios = 0;

		try {
			rs.next();
			usuarios = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("Erro ao contar usuarios cadastrados: " + e.getMessage());
		}

		return (usuarios == 0);
	}
}
