package main;

import conexao.Conexao;
import dao.DAOUsuario;
import dao.DAOFornecedor;
import entidades.Fornecedor;
import entidades.Usuario;
import gui.FornecedorController;
import gui.ListarFornecedoresController;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static Scene loginScene;
	private static Scene cadastroScene;

	private static FornecedorController fornecedorController;
	private static Scene fornecedorScene;

	private static Scene listaFornecedoresScene;
	private static ListarFornecedoresController listaFornecedoresController;
	
	private static Stage stage;

	private static DAOUsuario daoUsuario;
	private static DAOFornecedor daoFornecedor;
	private static Usuario usuarioAtual = null;

	public static DAOUsuario getDAOUsuario() {
		return daoUsuario;
	}

	public static DAOFornecedor getDAOFornecedor() {
		return daoFornecedor;
	}

	public static Usuario getUsuarioAtual() {
		return usuarioAtual;
	}

	public static void setUsuarioAtual(Usuario usuarioAtual) {
		Main.usuarioAtual = usuarioAtual;
	}

	public static void listarFornecedores() {
		listaFornecedoresController.atualizar();
		
		stage.setResizable(true);
		stage.setScene(listaFornecedoresScene);
	}

	public static void logar() {
		stage.setResizable(false);
		stage.setScene(loginScene);
	}

	public static void cadastrarFornecedor() {
		fornecedorController.setFornecedor(null);
		
		stage.setResizable(false);
		stage.setScene(fornecedorScene);
	}

	public static void alterarFornecedor(Fornecedor fornecedor) {
		fornecedorController.setFornecedor(fornecedor);
		
		stage.setResizable(false);
		stage.setScene(fornecedorScene);
	}

	public static void cadastrarUsuario() {
		stage.setResizable(false);
		stage.setScene(cadastroScene);
	}

	public static void main(String args[]) {
		Conexao conexao = new Conexao();
		
		boolean primeiroUsuario = false;

		usuarioAtual = new Usuario();
		
		daoUsuario = new DAOUsuario(conexao);
		daoFornecedor = new DAOFornecedor(conexao);

		launch(args);
	}

	public void start(Stage stage) {
		Main.stage = stage;
		Parent root;
		URL caminho;
		FXMLLoader loader;

		try {
			caminho = getClass().getResource("/Login.fxml");
			root = FXMLLoader.load(caminho);
			Main.loginScene = new Scene(root);

			caminho = getClass().getResource("/Cadastro.fxml");
			root = FXMLLoader.load(caminho);
			Main.cadastroScene = new Scene(root);

			caminho = getClass().getResource("/Fornecedor.fxml");
			loader = new FXMLLoader(caminho);
			root = (Parent) loader.load();
			Main.fornecedorController = (FornecedorController) loader.getController();
			Main.fornecedorScene = new Scene(root);

			caminho = getClass().getResource("/ListarFornecedores.fxml");
			loader = new FXMLLoader(caminho);
			root = (Parent) loader.load();
			Main.listaFornecedoresController = (ListarFornecedoresController) loader.getController();
			Main.listaFornecedoresScene = new Scene(root);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logar();
		stage.show();
	}
	
	public static void sair() {
		stage.close();
	}
}
