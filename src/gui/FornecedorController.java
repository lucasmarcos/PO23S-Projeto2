package gui;

import entidades.Fornecedor;
import main.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FornecedorController {
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
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(nome.getText());
		fornecedor.setTelefone(telefone.getText());
		fornecedor.setCnpj(cnpj.getText());
		fornecedor.setRua(rua.getText());
		fornecedor.setBairro(bairro.getText());
		fornecedor.setCep(cep.getText());
		
		Main.getDAOFornecedor().inserir(fornecedor);
		voltar(new ActionEvent());
	}
}
