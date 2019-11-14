package gui;

import main.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class InserirFornecedorController {
	@FXML
	void voltar(ActionEvent event) {
		Main.listarFornecedores();
	}

	@FXML
	void salvar(ActionEvent event) {
	}
}
