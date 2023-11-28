package br.ufrn.imd.controller;

import br.ufrn.imd.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
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
    private Button criarContaButton;

    @FXML
    void criarConta(ActionEvent event) {
        // Obter os dados do formulário
        String email = emailField.getText();
        String username = usernameField.getText();
        String senha = senhaField.getText();

        // Criar um objeto Usuario
        User user = new User(email, username, senha);

        // Salvar os dados em um arquivo
        salvarDados(user);

        // Limpar os campos após salvar
        limparCampos();
    }

    private void salvarDados(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_usuarios.txt", true))) {
            // Escrever os dados do usuário no arquivo
            writer.write(user.getEmail() + "\n");
            writer.write(user.getUsername() + "\n");
            writer.write(user.getSenha() + "\n");

            System.out.println("Dados do usuário salvos com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        // Limpar os campos do formulário
        emailField.clear();
        usernameField.clear();
        senhaField.clear();
    }
}
