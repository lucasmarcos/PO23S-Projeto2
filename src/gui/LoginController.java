package gui;

import entidades.Usuario;
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

	private DAOUsuario daoUsuario;

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
    
    public void setEmail(String email) {
        usuario.setText(email);
    }

	@FXML
	void entrar(ActionEvent event) {
		Usuario u = daoUsuario.login(usuario.getText(), senha.getText());

		if(u != null) {
			senha.clear();
			info.setVisible(false);

			Main.listarFornecedores(u);
		} else {
			info.setVisible(true);
			senha.clear();
		}
        
        usuario.requestFocus();
	}

	@FXML
	void sair(ActionEvent event) {
		Main.sair();
	}
}
