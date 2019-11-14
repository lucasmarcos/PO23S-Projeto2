package gui;

import main.Main;
import entidades.Fornecedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListarFornecedoresController {
	@FXML
	private Label nivel;

	@FXML
	private TextField filtro;

	@FXML
	private ListView<Fornecedor> fornecedores;

	@FXML
	private Label usuario;

	@FXML
	void alterar(ActionEvent event) {
	}

	@FXML
	void cadastrarFornecedor(ActionEvent event) {
		Main.cadastrarFornecedor();
	}

	@FXML
	void cadastrarUsuario(ActionEvent event) {
		Main.cadastrarUsuario();
	}

	@FXML
	void filtrar(ActionEvent event) {
	}

	@FXML
	void remover(ActionEvent event) {
	}

	@FXML
	void sair(ActionEvent event) {
		Main.logar();
	}
}
