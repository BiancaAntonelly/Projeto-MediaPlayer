package br.ufrn.imd.controller;

import br.ufrn.imd.service.Diretorio;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaDeUsuarioComumController {

    @FXML
    private Label UserName ;

    @FXML
    private Button AddDiretory;

    @FXML
    private Stage stage;

    private Diretorio diretorio = new Diretorio();

    private String id;

    public void setUser(String id, String name) {
        this.id = id;
        UserName.setText(name);
    }
    @FXML
    public void handleAddDiretory() throws IOException {
        diretorio.openDiretorio(id);
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleExit() {
        stage.close();
    }
}
