package gui;

import dao.DAOFornecedor;
import main.Main;
import entidades.Fornecedor;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarFornecedoresController implements Initializable {
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
	private Label usuario;

	@FXML
	void alterar(ActionEvent event) {
		Fornecedor fornecedor = fornecedores.getSelectionModel().getSelectedItem();
		Main.alterarFornecedor(fornecedor);
	}

	@FXML
	void remover(ActionEvent event) {
		DAOFornecedor dao = Main.getDAOFornecedor();
		Fornecedor fornecedor = fornecedores.getSelectionModel().getSelectedItem();
		dao.deletar(fornecedor);
		filtrar(new ActionEvent());
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

		String c = "";
		switch(campo.getSelectionModel().getSelectedIndex()) {
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
		
		List<Fornecedor> lista = dao.pesquisar(c, filtro.getText());

		fornecedores.getItems().clear();
		for(int i = 0; i < lista.size(); i++) {
			fornecedores.getItems().add(lista.get(i));
		}
	}

	@FXML
	void sair(ActionEvent event) {
		Main.logar();
	}
	
	public void atualizar() {
		filtrar(new ActionEvent());
		usuario.setText("Usuário: " + Main.getUsuarioAtual().getNome());
		if(Main.getUsuarioAtual().getAdministrador()) {
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
	}
}
