package gui;

import main.Main;
import dao.DAOUsuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private PasswordField senha;

	@FXML
	private TextField usuario;

	@FXML
	private Label info;

	@FXML
	void entrar(ActionEvent event) {
		DAOUsuario daoUsuario = Main.getDAOUsuario();
		if(daoUsuario.login(usuario.getText(), senha.getText())) {
			Main.listarFornecedores();
		} else {
			info.setVisible(true);
			senha.clear();
			usuario.requestFocus();
		}
	}
}
