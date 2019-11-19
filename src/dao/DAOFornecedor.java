package dao;

import conexao.Conexao;
import entidades.Fornecedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOFornecedor {
	private Conexao conexao;

	public DAOFornecedor(Conexao conexao) {
		this.conexao = conexao;
	}

	public void inserir(Fornecedor fornecedor) { // admin
		String sql = "INSERT INTO fornecedor (nome, telefone, cnpj, rua, bairro, cep )VALUES " +
			"('" + fornecedor.getNome() + "', '" +
			fornecedor.getTelefone() + "', '" + 
			fornecedor.getCnpj() + "', '" + 
			fornecedor.getRua() + "', '" + 
			fornecedor.getBairro() + "', '"	+
			fornecedor.getCep() + "');";
		conexao.executarSQL(sql);
	}

	public Fornecedor buscar(int codigo) {
		Fornecedor fornecedor = new Fornecedor();
		String sql = "SELECT codigo, nome, telefone, cnpj, rua, bairro, cep " + 
			"FROM fornecedor WHERE codigo = " + codigo + ";";
		
		try {
			ResultSet rs = conexao.buscar(sql);
			rs.next();
			
			fornecedor.setCodigo(rs.getInt("codigo"));
			fornecedor.setNome(rs.getString("nome"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setRua(rs.getString("rua"));
			fornecedor.setBairro(rs.getString("bairro"));
			fornecedor.setCep(rs.getString("cep"));
		} catch(Exception e) {
			System.out.println("Erro ao buscar fornecedor: " + e.getMessage());
		}
		
		return fornecedor;
	}

	public List<Fornecedor> pesquisar(String campo, String filtro) {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		String sql = "SELECT codigo, nome, telefone, cnpj, rua, bairro, cep " + 
			"FROM fornecedor WHERE " + campo + " ILIKE '%" + filtro + "%';";
		
		try {
			ResultSet rs = conexao.buscar(sql);
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCodigo(rs.getInt("codigo"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setTelefone(rs.getString("telefone"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				fornecedor.setRua(rs.getString("rua"));
				fornecedor.setBairro(rs.getString("bairro"));
				fornecedor.setCep(rs.getString("cep"));
				
				lista.add(fornecedor);
			}
		} catch(Exception e) {
			System.out.println("Erro ao pesquisar fornecedores: " + e.getMessage());
		}
		
		return lista;
	}

	public void alterar(Fornecedor fornecedor) { // admin
		String sql = "UPDATE fornecedor " + 
			"SET nome = '" + fornecedor.getNome() + "', " +
			"telefone = '" + fornecedor.getTelefone()+ "', " +
			"cnpj = '" + fornecedor.getCnpj()+ "', " +
			"rua = '" + fornecedor.getRua()+ "', " +
			"bairro = '" + fornecedor.getBairro()+ "', " +
			"cep = '" + fornecedor.getCep()+ "' " +
			"WHERE codigo = " + fornecedor.getCodigo() + ";";
		conexao.executarSQL(sql);
	}

	public void deletar(Fornecedor fornecedor) { // admin
		String sql = "DELETE FROM fornecedor WHERE codigo = " + fornecedor.getCodigo() + ";";
		try {
			conexao.executarSQL(sql);
		} catch(Exception e) {
			System.out.println("Erro ao deletar fornecedor: " + e.getMessage());
		}
	}
}
