package gui;

import main.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroController {
	@FXML
	private PasswordField senha;

	@FXML
	private CheckBox administrador;

	@FXML
	private PasswordField verificar_senha;

	@FXML
	private TextField nome;

	@FXML
	private TextField email;

	@FXML
	void cadastrar(ActionEvent event) {

	}

	@FXML
	void voltar(ActionEvent event) {
		Main.listarFornecedores();
	}
}
