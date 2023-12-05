package br.ufrn.imd.controller;

import br.ufrn.imd.model.Usuario;
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

                String tipoUsuario = autenticarUsuario(username, senha);

                if (tipoUsuario != null) {
                        String fxmlPath;
                        String title;

                        if ("usuario comum".equals(tipoUsuario)) {
                                fxmlPath = "br.ufrn.imd.visao\\TelaDeUsuarioComum.fxml";
                                title = "Tela de Inicio - Usuário Comum";
                        } else if ("usuario vip".equals(tipoUsuario)) {
                                fxmlPath = "br.ufrn.imd.visao\\TelaDeUsuarioVip.fxml";
                                title = "Tela de Inicio - Usuário Vip";
                        } else {
                                mensagemErro.setVisible(true);
                                mensagemErro.setText("Tipo de usuário não reconhecido.");
                                return;
                        }

                        carregarPagina(fxmlPath, title);
                } else {
                        mensagemErro.setVisible(true);
                        mensagemErro.setText("Nome de usuário ou senha incorretos. Tente novamente.");
                }
        }


        @FXML
        private void handleCriarConta() {
                carregarPagina("TelaDeCadastro.fxml", "Cadastro");
        }

        private String autenticarUsuario(String username, String senha) {
                Path usuariosPath = Paths.get("C:\\Users\\bianc\\OneDrive\\Documentos\\GitHub\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\usuarios.txt");

                try (BufferedReader reader = Files.newBufferedReader(usuariosPath)) {
                        String email, usuario, senhaArmazenada, tipoUsuario;

                        while ((email = reader.readLine()) != null) {
                                usuario = reader.readLine().toLowerCase();
                                senhaArmazenada = reader.readLine();
                                tipoUsuario = reader.readLine();

                                if (usuario.equals(username) && senha.equals(senhaArmazenada)) {
                                        return tipoUsuario;
                                }
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return null;
        }



        private void carregarPagina(String fxmlPath, String title) {
                try {
                        //String caminhoFXML = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\resources\\" + fxmlPath;
                        String caminhoFXML = "C:\\Users\\bianc\\OneDrive\\Documentos\\GitHub\\Projeto-MediaPlayer\\src\\main\\resources\\" + fxmlPath;

                        FXMLLoader loader = new FXMLLoader(new File(caminhoFXML).toURI().toURL());
                        Parent root = loader.load();

                        TelaDeUsuarioComumController telaUsuarioComumController = loader.getController();
                        telaUsuarioComumController.setUserName(tfUsername.getText());

                        Stage stage = (Stage) criarContaButton.getScene().getWindow();
                        telaUsuarioComumController.setStage(stage);

                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle(title);
                        stage.show();
                } catch (IOException e) {
                        System.out.println(e);
                        e.printStackTrace();
                }
        }

        private Usuario buscarUsuario(String name, String email) {
                return  null;
        }
}

