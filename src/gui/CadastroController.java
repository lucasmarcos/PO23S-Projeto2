package gui;

import dao.DAOUsuario;
import entidades.Usuario;
import javafx.scene.control.*;
import main.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CadastroController {
	private DAOUsuario daoUsuario;

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	private boolean primeiroUsuario;

	public void setPrimeiroUsuario(boolean primeiroUsuario) {
		this.primeiroUsuario = primeiroUsuario;

		label_primerio.setVisible(primeiroUsuario);
		administrador.setSelected(primeiroUsuario);
		administrador.setDisable(primeiroUsuario);
		botao_voltar.setVisible(!primeiroUsuario);
	}

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
	private Button botao_voltar;

	@FXML
	private Label label_senha;

	@FXML
	private Label label_primerio;

	@FXML
	void cadastrar(ActionEvent event) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome.getText());
		usuario.setEmail(email.getText());
		usuario.setAdministrador(administrador.isSelected());

		if(senha.getText().equals(verificar_senha.getText()) && !senha.getText().isEmpty()) {
			usuario.setSenha(senha.getText());
			daoUsuario.inserir(usuario);
			if(!primeiroUsuario) {
				limpar();
				Main.listarFornecedores();
			} else {
				setPrimeiroUsuario(false);
				limpar();
				Main.logar();
			}
		} else {
			label_senha.setVisible(true);
			senha.clear();
			verificar_senha.clear();
			senha.requestFocus();
		}
	}

	@FXML
	void voltar(ActionEvent event) {
		limpar();
		Main.listarFornecedores();
	}

	private void limpar() {
		senha.clear();
		verificar_senha.clear();
		nome.clear();
		email.clear();
		administrador.setSelected(false);
	}
}
