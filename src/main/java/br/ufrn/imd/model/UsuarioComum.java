package br.ufrn.imd.model;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class UsuarioComum extends Usuario {
    private String directory;

    @FXML
    private ListView<Playlist> playlistView;

    public UsuarioComum(String id, String email, String username, String password) {
        super(id, email, username, password);
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
