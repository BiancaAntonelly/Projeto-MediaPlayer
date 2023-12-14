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
import java.net.MalformedURLException;
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

        private String id;

        @FXML
        private void initialize() {
                mensagemErro.setVisible(false);
        }

        @FXML
        private void handleEntrar() {
                String username = tfUsername.getText().toLowerCase();
                String senha = pfSenha.getText();

                String tipoUsuario = autenticarUsuario(username, senha);

                System.out.println("tipo: " + tipoUsuario);
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

                        carregarPagina(fxmlPath, title, tipoUsuario);
                } else {
                        mensagemErro.setVisible(true);
                        mensagemErro.setText("Nome de usuário ou senha incorretos. Tente novamente.");
                }
        }

        @FXML
        private void handleCriarConta() throws IOException {
                String caminho = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\resources\\br.ufrn.imd.visao\\TelaDeCadastro.fxml";
                FXMLLoader loader = new FXMLLoader(new File(caminho).toURI().toURL());
                Parent root = loader.load();

                Stage stage = (Stage) criarContaButton.getScene().getWindow();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Cadastro");
                stage.show();
        }

        private String autenticarUsuario(String username, String senha) {
                Path usuariosPath = Paths.get("C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\usuarios.txt");
                //"C:\\Users\\bianc\\OneDrive\\Documentos\\GitHub\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\usuarios.txt"

                try (BufferedReader reader = Files.newBufferedReader(usuariosPath)) {
                        String email, id, usuario, senhaArmazenada, tipoUsuario;

                        while ((email = reader.readLine()) != null) {
                                id = reader.readLine();
                                usuario = reader.readLine().toLowerCase();
                                senhaArmazenada = reader.readLine();
                                tipoUsuario = reader.readLine();

                                System.out.println("email: "+ email + " id: "+ id + " login: "+ usuario + " senha: "+ senhaArmazenada);
                                if (usuario.equals(username) && senha.equals(senhaArmazenada)) {
                                        this.id = id;
                                        return tipoUsuario;
                                }
                        }
                } catch (IOException e) {

                        e.printStackTrace();
                }
                return null;
        }



        private void carregarPagina(String fxmlPath, String title, String tipo) {
                try {

                        String caminhoFXML = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\resources\\" + fxmlPath;
                        //String caminhoFXML = "C:\\Users\\bianc\\OneDrive\\Documentos\\GitHub\\Projeto-MediaPlayer\\src\\main\\resources\\" + fxmlPath;

                        FXMLLoader loader = new FXMLLoader(new File(caminhoFXML).toURI().toURL());
                        Parent root = loader.load();

                        TelaDeUsuarioComumController telaUsuarioComumController = new TelaDeUsuarioComumController();
                        TelaDeUsuarioVipController telaDeUsuarioVipController = new TelaDeUsuarioVipController();

                        Stage stage = (Stage) criarContaButton.getScene().getWindow();

                        if(tipo.equals("usuario comum")) {
                                 telaUsuarioComumController = loader.getController();
                                telaUsuarioComumController.setUser(id, tfUsername.getText());
                                telaUsuarioComumController.setStage(stage);
                        } else if(tipo.equals("usuario vip")){
                                telaDeUsuarioVipController = loader.getController();
                                telaDeUsuarioVipController.setUser(id, tfUsername.getText());
                                telaDeUsuarioVipController.setStage(stage);
                        }

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

