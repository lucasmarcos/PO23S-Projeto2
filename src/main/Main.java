package main;

import conexao.Conexao;
import dao.DAOUsuario;
import dao.DAOFornecedor;
import entidades.Usuario;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static Scene loginScene;
	private static Scene cadastroScene;
	private static Scene fornecedoresScene;
	private static Scene listaFornecedoresScene;

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
		stage.setResizable(true);
		stage.setScene(listaFornecedoresScene);
	}

	public static void logar() {
		stage.setResizable(true);
		stage.setScene(loginScene);
		stage.setResizable(false);
	}

	public static void cadastrarFornecedor() {
		stage.setResizable(true);
		stage.setScene(fornecedoresScene);
	}

	public static void cadastrarUsuario() {
		stage.setResizable(true);
		stage.setScene(cadastroScene);
	}

	public static void main(String args[]) {
		Conexao conexao = new Conexao();

		daoUsuario = new DAOUsuario(conexao);
		daoFornecedor = new DAOFornecedor(conexao);

		launch(args);
	}

	public void start(Stage stage) {
		Main.stage = stage;
		Parent root;
		URL caminho;

		try {
			caminho = getClass().getResource("/Login.fxml");
			root = FXMLLoader.load(caminho);
			Main.loginScene = new Scene(root);

			caminho = getClass().getResource("/Cadastro.fxml");
			root = FXMLLoader.load(caminho);
			Main.cadastroScene = new Scene(root);

			caminho = getClass().getResource("/Fornecedor.fxml");
			root = FXMLLoader.load(caminho);
			Main.fornecedoresScene = new Scene(root);

			caminho = getClass().getResource("/ListarFornecedores.fxml");
			root = FXMLLoader.load(caminho);
			Main.listaFornecedoresScene = new Scene(root);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logar();
		stage.show();
	}
}
