package br.ufrn.imd.controller;

import br.ufrn.imd.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaUsuarioController {

    @FXML
    private Label UserName ;
    public void setUserName(String nome) {
        UserName.setText(nome);
    }
}
