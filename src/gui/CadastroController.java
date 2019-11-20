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
	private Label label_erro;

	@FXML
	private Label label_primerio;
        
        private boolean admin = false;
        
        public void setAdmin(boolean admin) {
            this.admin = admin;
            administrador.setDisable(!admin);
        }

	@FXML
	void cadastrar(ActionEvent event) {
		Usuario usuario = new Usuario();
		usuario.setAdministrador(administrador.isSelected());

        if(nome.getText().length() == 0) {
            label_erro.setText("Nome vazio");
            nome.requestFocus();
            return;
        }
		usuario.setNome(nome.getText());
        
        if(email.getText().length() == 0) {
            label_erro.setText("E-mail vazio");
            email.requestFocus();
            return;
        }
		usuario.setEmail(email.getText());
        
		if(senha.getText().equals(verificar_senha.getText()) && !senha.getText().isEmpty()) {
			usuario.setSenha(senha.getText());
			daoUsuario.inserir(usuario);
			if(!primeiroUsuario) {
				limpar();
				Main.listarFornecedores();
			} else {
				setPrimeiroUsuario(false);
				limpar();
                Main.setProximoLogin(usuario.getEmail());
				Main.logar();
			}
		} else {
			label_erro.setText("As senhas não conferem");
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
