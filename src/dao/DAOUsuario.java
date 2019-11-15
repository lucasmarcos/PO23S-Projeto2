package dao;

import conexao.Conexao;
import entidades.Usuario;
import java.sql.ResultSet;
import main.Main;

public class DAOUsuario {
	private Conexao conexao;

	public DAOUsuario(Conexao conexao) {
		this.conexao = conexao;
	}

	public void inserir(Usuario usuario) {
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
			e.printStackTrace();
		}
		
		return usuario;
	}

	public boolean login(String email, String senha) {
		String sql = "SELECT codigo FROM usuario WHERE" +
			" email = '" + email +
			"' AND senha = '" + senha + "';";
		
		ResultSet rs = conexao.buscar(sql);
		try {
			rs.next();
			int codigo = rs.getInt("codigo");
			
			Usuario usuario = buscar(codigo);
			Main.setUsuarioAtual(usuario);
	
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}