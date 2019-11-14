package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexao {
	private Connection connection;

	private String uri;
	private String usuario;
	private String senha;

	public Conexao() {
		uri = "jdbc:postgresql:projeto2";
		usuario = "postgres";
		senha = "aluno";

		try {
			connection = DriverManager.getConnection(uri, usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean executarSQL(String sql) {
		try {
			Statement stm = connection.createStatement();
			stm.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void inserir() {
	}

	public void atualizar() {
	}

	public void buscar() {
	}

	public void pesquisar() {
	}
}
