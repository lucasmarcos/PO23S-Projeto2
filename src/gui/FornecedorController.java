package gui;

import dao.DAOFornecedor;
import entidades.Fornecedor;
import javafx.scene.control.Label;
import main.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FornecedorController {
	private Fornecedor fornecedor;

	private DAOFornecedor daoFornecedor;

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;

		if (fornecedor != null) {
			nome.setText(fornecedor.getNome());
			telefone.setText(fornecedor.getTelefone());
			cnpj.setText(fornecedor.getCnpj());
			rua.setText(fornecedor.getRua());
			bairro.setText(fornecedor.getBairro());
			cep.setText(fornecedor.getCep());

			label_alterando.setVisible(true);
			label_alterando.setText("Alterando o Fornecedor de Código " + fornecedor.getCodigo());
		} else {
			label_alterando.setVisible(false);
		}
	}

	public void setDaoFornecedor(DAOFornecedor daoFornecedor) {
		this.daoFornecedor = daoFornecedor;
	}

	@FXML
	private TextField nome;

	@FXML
	private TextField telefone;

	@FXML
	private TextField cnpj;

	@FXML
	private TextField rua;

	@FXML
	private TextField bairro;

	@FXML
	private TextField cep;

	@FXML
	private Label label_erro;

	@FXML
	private Label label_alterando;

	@FXML
	void voltar(ActionEvent event) {
		nome.clear();
		telefone.clear();
		cnpj.clear();
		rua.clear();
		bairro.clear();
		cep.clear();

		Main.listarFornecedores();
	}

	@FXML
	void salvar(ActionEvent event) {
		boolean alterar = false;
		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		} else {
			alterar = true;
		}

		fornecedor.setNome(nome.getText());
		fornecedor.setTelefone(telefone.getText());
		fornecedor.setCnpj(cnpj.getText());
		fornecedor.setRua(rua.getText());
		fornecedor.setBairro(bairro.getText());
		fornecedor.setCep(cep.getText());

		if (alterar) {
			daoFornecedor.alterar(fornecedor);
		} else {
			daoFornecedor.inserir(fornecedor);
		}

		voltar(new ActionEvent());
	}

}
