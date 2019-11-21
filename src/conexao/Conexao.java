package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			criarTabelas();
		} catch (Exception e) {
			System.out.println("Erro ao estabelecer conexao com o banco de dados: " + e.getMessage());
		}
	}

	private void criarTabelas() {
		String tabelaUsuario = "CREATE TABLE IF NOT EXISTS usuario (" +
    		"codigo SERIAL PRIMARY KEY," +
    		"nome VARCHAR," +
    		"email VARCHAR," +
    		"senha VARCHAR," +
    		"administrador BOOLEAN" +
		");";
		
		String tabelaFornecedor = "CREATE TABLE IF NOT EXISTS fornecedor (" +
    		"codigo SERIAL PRIMARY KEY," +
    		"nome VARCHAR," +
    		"telefone VARCHAR," +
    		"cnpj VARCHAR," +
    		"rua VARCHAR," +
    		"bairro VARCHAR," +
    		"cep VARCHAR" +
		");";

		executarSQL(tabelaUsuario);
		executarSQL(tabelaFornecedor);
	}

	public boolean executarSQL(String sql) {
		try {
			Statement stm = connection.createStatement();
			stm.execute(sql);
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao executar sql: " + e.getMessage());
		}

		return false;
	}

	public ResultSet buscar(String sql) {
		ResultSet rs = null;

		try {
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("Erro ao executar busca sql: " + e.getMessage());
		}

		return rs;
	}
}
