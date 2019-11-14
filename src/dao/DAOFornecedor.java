package dao;

import conexao.Conexao;
import entidades.Fornecedor;

public class DAOFornecedor {
	private Conexao conexao;

	public DAOFornecedor(Conexao conexao) {
		this.conexao = conexao;
	}

	public void inserir(Fornecedor fornecedor) { // admin
	}

	public Fornecedor buscar(int codigo) {
		return new Fornecedor();
	}

	public void alterar(Fornecedor fornecedor) { // admin
	}

	public void deletar(Fornecedor fornecedor) { // admin
	}
}
