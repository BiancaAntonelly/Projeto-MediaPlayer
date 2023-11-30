package br.ufrn.imd.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TelaDeLoginController {

        @FXML
        private TextField tfUsername;

        @FXML
        private PasswordField pfSenha;

        @FXML
        private Button entrarButton;

        @FXML
        private Button criarContaButton;

        @FXML
        private Text mensagemErro;

        @FXML
        private void initialize() {
                mensagemErro.setVisible(false);
        }

        @FXML
        private void handleEntrar() {
                String username = tfUsername.getText().toLowerCase();
                String senha = pfSenha.getText();

                if (autenticarUsuario(username, senha)) {
                        carregarPagina("TelaDeInicio.fxml", "Tela de Inicio");
                } else {
                        mensagemErro.setVisible(true);
                        mensagemErro.setText("Nome de usuário ou senha incorretos. Tente novamente.");
                }
        }

        @FXML
        private void handleCriarConta() {
                carregarPagina("TelaDeCadastro.fxml", "Cadastro");
        }

        private boolean autenticarUsuario(String username, String senha) {
                Path usuariosPath = Paths.get("C:\\Users\\bianc\\OneDrive\\Documentos\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\usuarios.txt");

                try (BufferedReader reader = Files.newBufferedReader(usuariosPath)) {
                        String email, usuario, senhaArmazenada, tipoUsuario;

                        while ((email = reader.readLine()) != null) {
                                usuario = reader.readLine().toLowerCase();
                                senhaArmazenada = reader.readLine();
                                tipoUsuario = reader.readLine();

                                if (usuario.equals(username) && senha.equals(senhaArmazenada)) {
                                        return true; // Nome de usuário e senha coincidem
                                }
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return false;
        }


        private void carregarPagina(String fxmlPath, String title) {
                try {
                        String caminhoFXML = "C:\\Users\\bianc\\OneDrive\\Documentos\\Projeto-MediaPlayer\\src\\main\\resources\\br.ufrn.imd.visao\\" + fxmlPath;

                        Parent root = FXMLLoader.load(new File(caminhoFXML).toURI().toURL());

                        Stage stage = (Stage) criarContaButton.getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle(title);
                        stage.show();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}

