package br.ufrn.imd.controller;

import br.ufrn.imd.model.Musica;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.service.Diretorio;
import br.ufrn.imd.service.PlayListService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaDeUsuarioComumController {

    @FXML
    private Label UserName ;

    @FXML
    private Button AddDiretory;

    @FXML
    private Button addPlayList;

    @FXML
    private Stage stage;

    @FXML
    ListView<String> playListView;

    @FXML
    private ListView<String> listaMusicasView;

    @FXML
    private Button addSong;
    private Diretorio diretorio = new Diretorio();

    private String id;

    private List<Musica> musicas = new ArrayList<>();

    private List<Playlist> playlists = new ArrayList<>();

    private PlayListService playListService = new PlayListService();

    private String nomePlayList;

    public void setUser(String id, String name) throws IOException {
        this.id = id;
        UserName.setText(name);
        updatePlayList();
        //criarPlayList.setStyle("visibility: block");
        musicas = playlists.get(0).getMusicas();
        ObservableList<String> dadosDaListView2 = FXCollections.observableArrayList();
        for (Musica m: musicas) {
            dadosDaListView2.add(m.getName());
        }

        listaMusicasView.setItems(dadosDaListView2);
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

    @FXML
    public void handleCliqueMouse() {
        playListView.setOnMouseClicked(mouseEvent -> {
                String selectedItem = playListView.getSelectionModel().getSelectedItem();
                nomePlayList = selectedItem;
                listarMusicas(nomePlayList);
        });
    }

    public void updatePlayList() {
        playlists = playListService.buscarPlayListsPorUser(id);
        ObservableList<String> dadosDaListView = FXCollections.observableArrayList();

        for (Playlist p: playlists) {
            System.out.println(p.getMusicas());
            dadosDaListView.add(p.getName());
        }

        playListView.setItems(dadosDaListView);
    }
    public void listarMusicas(String lista) {
        for (Playlist l:
             playlists) {
            if(l.getName().equals(lista)) {
                ObservableList<String> dadosDaListView3 = FXCollections.observableArrayList();
                for (Musica m: l.getMusicas()) {
                    dadosDaListView3.add(m.getName());
                }

                listaMusicasView.setItems(dadosDaListView3);
            }
        }
    }
   @FXML
    public void handleAddSong() throws IOException {
        if(nomePlayList == null) {
            nomePlayList = playlists.get(0).getName();
        }

        for (Playlist l: playlists) {
            if(l.getName().equals(nomePlayList)) {
                playListService.addMusica(l.getName(), id);
                updatePlayList();
            }
        }
    }

    @FXML
    public void handleAddPlayList() {
    }

}
