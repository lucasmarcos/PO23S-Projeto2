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
		return new Fornecedor();
	}

	public List<Fornecedor> pesquisar(String filtro) {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		String sql = "SELECT codigo, nome, telefone, cnpj, rua, bairro, cep FROM fornecedor WHERE nome ILIKE '%" + filtro + "%';";
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
			e.printStackTrace();
		}
		
		return lista;
	}

	
	public void alterar(Fornecedor fornecedor) { // admin
	}

	public void deletar(Fornecedor fornecedor) { // admin
	}
}
