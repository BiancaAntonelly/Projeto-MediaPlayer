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
import java.io.FileReader;
import java.io.IOException;

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
                        carregarProximaCena("C:\\Users\\bianc\\OneDrive\\Documentos\\Projeto-MediaPlayer\\src\\main\\resources\\br.ufrn.imd.visao\\TelaDeInicio.fxml");
                } else {
                        mensagemErro.setVisible(true);
                        mensagemErro.setText("Nome de usuário ou senha incorretos. Tente novamente.");
                }
        }

        @FXML
        private void handleCriarConta() {
                carregarProximaCena("C:\\Users\\bianc\\OneDrive\\Documentos\\Projeto-MediaPlayer\\src\\main\\resources\\br.ufrn.imd.visao\\TelaDeCadastro.fxml");
        }

        private boolean autenticarUsuario(String username, String senha) {
                try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\bianc\\OneDrive\\Documentos\\GitHub\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\usuarios.txt"))) {
                        String line;
                        int lineNumber = 0;
                        while ((line = reader.readLine()) != null) {
                                if (lineNumber % 4 == 2 && line.trim().toLowerCase().equals(username)) {
                                        String senhaArmazenada = reader.readLine();
                                        return senha.equals(senhaArmazenada);
                                }
                                lineNumber++;
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return false;
        }

        private void carregarProximaCena(String fxmlResource) {
                try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlResource));
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) entrarButton.getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
