package gui;

import javafx.scene.input.MouseEvent;
import main.Main;
import dao.DAOFornecedor;
import dao.DAOUsuario;
import entidades.Usuario;
import entidades.Fornecedor;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class ListarFornecedoresController implements Initializable {
	private DAOUsuario daoUsuario;

	private DAOFornecedor daoFornecedor;

	private Usuario usuarioAtual;

	@FXML
	private Label nivel;

	@FXML
	private TextField filtro;

	@FXML
	private ChoiceBox<String> campo;

	@FXML
	private TableView<Fornecedor> fornecedores;

	@FXML
	private TableColumn<Fornecedor, String> colunaNome;

	@FXML
	private TableColumn<Fornecedor, String> colunaTelefone;

	@FXML
	private TableColumn<Fornecedor, String> colunaCnpj;

	@FXML
	private TableColumn<Fornecedor, String> colunaRua;

	@FXML
	private TableColumn<Fornecedor, String> colunaBairro;

	@FXML
	private TableColumn<Fornecedor, String> colunaCep;

	@FXML
	private Button botao_remover;

	@FXML
	private Button botao_alterar;

	@FXML
	private Button botao_cadastrar_fornecedor;

	@FXML
	private Label usuario;

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public void setDaoFornecedor(DAOFornecedor daoFornecedor) {
		this.daoFornecedor = daoFornecedor;
	}

	public void setUsuarioAtual(Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}

	@FXML
	void alterar(ActionEvent event) {
		Fornecedor fornecedor = fornecedores.getSelectionModel().getSelectedItem();
		if(fornecedor != null) {
			Main.alterarFornecedor(fornecedor);
		}
	}

	@FXML
	void remover(ActionEvent event) {
		Fornecedor fornecedor = fornecedores.getSelectionModel().getSelectedItem();
		if(fornecedor != null) {
			daoFornecedor.deletar(fornecedor);
			filtrar(null);
			botao_alterar.setVisible(false);
			botao_remover.setVisible(false);
		}
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
	void removerUsuarioAtual(ActionEvent event) {
		daoUsuario.remover(usuarioAtual);
		Main.logar("");
	}

	@FXML
	void filtrar(KeyEvent event) {
		String c = "";
		switch (campo.getSelectionModel().getSelectedIndex()) {
			case 0:
				c = "nome";
				break;
			case 1:
				c = "telefone";
				break;
			case 2:
				c = "cnpj";
				break;
			case 3:
				c = "rua";
				break;
			case 4:
				c = "bairro";
				break;
			case 5:
				c = "cep";
				break;
		}

		List<Fornecedor> lista = daoFornecedor.pesquisar(c, filtro.getText());

		fornecedores.getItems().clear();
		botao_alterar.setVisible(false);
		botao_remover.setVisible(false);
		for(int i = 0; i < lista.size(); i++) {
			fornecedores.getItems().add(lista.get(i));
		}
	}

	@FXML
	void sair(ActionEvent event) {
		Main.logar();
	}

	public void atualizar() {
		filtrar(null);

		if(usuarioAtual != null) {
			botao_alterar.setDisable(!usuarioAtual.getAdministrador());
			botao_remover.setDisable(!usuarioAtual.getAdministrador());
			botao_cadastrar_fornecedor.setDisable(!usuarioAtual.getAdministrador());
		}

		usuario.setText("Usuario Atual: " + usuarioAtual.getNome());

		if (usuarioAtual.getAdministrador()) {
			nivel.setText("Administrador");
		} else {
			nivel.setText("Empregado");
		}
	}

	public void initialize(URL url, ResourceBundle rb) {
		campo.getItems().addAll("Nome", "Telefone", "CNPJ", "Rua", "Bairro", "CEP");
		campo.getSelectionModel().select(0);

		colunaNome.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome"));
		colunaTelefone.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("telefone"));
		colunaCnpj.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cnpj"));
		colunaRua.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("rua"));
		colunaBairro.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("bairro"));
		colunaCep.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("cep"));

		botao_alterar.setVisible(false);
		botao_remover.setVisible(false);
	}

	@FXML
	void cliqueLista(MouseEvent event) {
		if(fornecedores.getSelectionModel().getSelectedIndex() >= 0) {
			botao_alterar.setVisible(true);
			botao_remover.setVisible(true);
		} else {
			botao_alterar.setVisible(false);
			botao_remover.setVisible(false);
		}
	}
}
