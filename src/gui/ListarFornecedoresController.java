package gui;

import dao.DAOFornecedor;
import main.Main;
import entidades.Fornecedor;
import java.util.List;

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
	private ListView<String> fornecedores;

	@FXML
	private Label usuario;

	@FXML
	void alterar(ActionEvent event) {
		String item = fornecedores.getSelectionModel().getSelectedItem();
		System.out.println(item);
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
		DAOFornecedor dao = Main.getDAOFornecedor();
		List<Fornecedor> lista = dao.pesquisar(filtro.getText());

		fornecedores.getItems().clear();
		for(int i = 0; i < lista.size(); i++) {
			fornecedores.getItems().add(lista.get(i).getNome());
		}
	}

	@FXML
	void remover(ActionEvent event) {
	}

	@FXML
	void sair(ActionEvent event) {
		Main.logar();
	}
	
	public void atualizar() {
		filtrar(new ActionEvent());
		usuario.setText(Main.getUsuarioAtual().getNome());
		if(Main.getUsuarioAtual().getAdministrador()) {
			nivel.setText("Administrador");
		} else {
			nivel.setText("Empregado");
		}
	}
}
