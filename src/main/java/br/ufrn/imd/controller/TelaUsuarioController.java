package br.ufrn.imd.controller;

import br.ufrn.imd.model.Usuario;
import br.ufrn.imd.service.Diretorio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaUsuarioController {

    @FXML
    private Label UserName ;

    @FXML
    private Button AddDiretory;

    @FXML
    private Stage stage;

    private Diretorio diretorio = new Diretorio();
    public void setUserName(String nome) {
        UserName.setText(nome);
    }

    @FXML
    public void handleAddDiretory() throws IOException {
        diretorio.addDiretorio(3, "nome");
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleExit() {
        stage.close();
    }
}
