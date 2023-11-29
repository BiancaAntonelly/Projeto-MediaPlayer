package br.ufrn.imd.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class TelaDeInicioController {

    @FXML
    private Button loginButton;
    @FXML
    private Button criarContaButton;

    @FXML
    private void handleLoginButton() {
        System.out.println("Botão de Login clicado!");
        carregarPagina("TelaDeLogin.fxml", "Login");
    }

    @FXML
    private void handleCriarContaButton() {
        System.out.println("Botão de Criar Conta clicado!");
        carregarPagina("TelaDeCadastro.fxml", "Cadastro");
    }


    private void carregarPagina(String fxmlPath, String title) {
        try {
            String caminhoFXML = "C:\\Users\\bianc\\OneDrive\\Documentos\\Projeto-MediaPlayer\\src\\main\\resources\\br.ufrn.imd.visao\\" + fxmlPath;

            Parent root = FXMLLoader.load(new File(caminhoFXML).toURI().toURL());

            Stage stage = (Stage) loginButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
