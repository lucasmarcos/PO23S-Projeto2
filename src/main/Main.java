package main;

import conexao.Conexao;
import dao.DAOUsuario;
import dao.DAOFornecedor;
import entidades.Fornecedor;
import entidades.Usuario;
import gui.CadastroController;
import gui.FornecedorController;
import gui.ListarFornecedoresController;

import java.net.URL;

import gui.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static Scene loginScene;
	private static LoginController loginController;

	private static Scene cadastroScene;
	private static CadastroController cadastroController;

	private static Scene fornecedorScene;
	private static FornecedorController fornecedorController;

	private static Scene listaFornecedoresScene;
	private static ListarFornecedoresController listaFornecedoresController;

	private static Stage stage;

	public static void listarFornecedores() {
		listaFornecedoresController.atualizar();

		stage.setResizable(true);
		stage.setScene(listaFornecedoresScene);
	}

	public static void listarFornecedores(Usuario usuario) {
		listaFornecedoresController.setUsuarioAtual(usuario);
        cadastroController.setAdmin(usuario.getAdministrador());
		listarFornecedores();
	}

	public static void logar() {
		if(loginController.cadastroAdmin()) {
			cadastroController.setPrimeiroUsuario(true);
			cadastrarUsuario();
		} else {
			stage.setMaximized(false);
			stage.setResizable(false);
			stage.setScene(loginScene);
		}
	}

	public static void logar(String email) {
		loginController.setEmail(email);
		logar();
	}

	public static void cadastrarFornecedor() {
		fornecedorController.setFornecedor(null);

		stage.setMaximized(false);
		stage.setResizable(false);
		stage.setScene(fornecedorScene);
	}

	public static void alterarFornecedor(Fornecedor fornecedor) {
		fornecedorController.setFornecedor(fornecedor);

		stage.setMaximized(false);
		stage.setResizable(false);
		stage.setScene(fornecedorScene);
	}

	public static void cadastrarUsuario() {
		stage.setMaximized(false);
		stage.setResizable(false);
		stage.setScene(cadastroScene);
	}
    
    public static void main(String args[]) {
		launch(args);
	}

	public void start(Stage stage) {
		Main.stage = stage;
		Parent root;
		URL caminho;
		FXMLLoader loader;

		Conexao conexao = new Conexao();

		DAOUsuario daoUsuario = new DAOUsuario(conexao);
		DAOFornecedor daoFornecedor = new DAOFornecedor(conexao);

		try {
			// tela de login
			caminho = getClass().getResource("/Login.fxml");
			loader = new FXMLLoader(caminho);
			root = (Parent) loader.load();

			loginController = (LoginController) loader.getController();
			loginController.setDaoUsuario(daoUsuario);

			loginScene = new Scene(root);

			// tela de cadastro de usuarios
			caminho = getClass().getResource("/Cadastro.fxml");
			loader = new FXMLLoader(caminho);
			root = (Parent) loader.load();

			cadastroController = (CadastroController) loader.getController();
			cadastroController.setDaoUsuario(daoUsuario);

			cadastroScene = new Scene(root);

			// tela de cadastro e alteracao de fornecedores
			caminho = getClass().getResource("/Fornecedor.fxml");
			loader = new FXMLLoader(caminho);
			root = (Parent) loader.load();

			fornecedorController = (FornecedorController) loader.getController();
			fornecedorController.setDaoFornecedor(daoFornecedor);

			fornecedorScene = new Scene(root);

			// tela principal de listar fornecedores e navegacao
			caminho = getClass().getResource("/ListarFornecedores.fxml");
			loader = new FXMLLoader(caminho);
			root = (Parent) loader.load();

			listaFornecedoresController = (ListarFornecedoresController) loader.getController();
			listaFornecedoresController.setDaoUsuario(daoUsuario);
			listaFornecedoresController.setDaoFornecedor(daoFornecedor);

			listaFornecedoresScene = new Scene(root);
		} catch (Exception e) {
			System.out.println("Erro ao inicializar as telas: " + e.getMessage());
		}

		logar();
		stage.show();
	}

	public static void sair() {
		stage.close();
	}
}