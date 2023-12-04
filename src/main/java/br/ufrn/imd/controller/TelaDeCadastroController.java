package br.ufrn.imd.controller;

import br.ufrn.imd.model.UsuarioComum;
import br.ufrn.imd.model.UsuarioVip;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TelaDeCadastroController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private CheckBox usuarioComumCheckbox;

    @FXML
    private CheckBox usuarioVipCheckbox;

    @FXML
    private Button criarContaButton;

    @FXML
    void initialize() {
        // Adiciona um listener para o evento de clique do botão
        criarContaButton.setOnAction(event -> criarConta(event));
    }

    @FXML
    void criarConta(javafx.event.ActionEvent event) {
        Integer id = 1;
        String email = emailField.getText();
        String username = usernameField.getText();
        String senha = senhaField.getText();

        if (usuarioComumCheckbox.isSelected()) {
            UsuarioComum usuarioComum = new UsuarioComum(id, email, username, senha);
            salvarUsuario(email, username, senha, "usuario comum");
        }

        if (usuarioVipCheckbox.isSelected()) {
            UsuarioVip usuarioVip = new UsuarioVip(id, email, username, senha);
            // Adicione lógica específica para usuários VIP, se necessário
            salvarUsuario(email, username, senha, "usuario vip");
        }

        carregarPaginaLogin();

        limparCampos();
    }

    private void salvarUsuario(String email, String username, String senha, String tipoUsuario) {
        String caminhoArquivo = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\usuarios.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            writer.write(email);
            writer.newLine();
            writer.write(username);
            writer.newLine();
            writer.write(senha);
            writer.newLine();
            writer.write(tipoUsuario);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void carregarPaginaLogin() {
        try {
            String caminhoFXML = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\resources\\br.ufrn.imd.visao\\TelaDeInicio.fxml";

            Parent root = FXMLLoader.load(new File(caminhoFXML).toURI().toURL());

            Stage stage = (Stage) criarContaButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void limparCampos() {
        emailField.setText("");
        usernameField.setText("");
        senhaField.setText("");
        usuarioComumCheckbox.setSelected(false);
        usuarioVipCheckbox.setSelected(false);
    }
}
