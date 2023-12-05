package br.ufrn.imd.model;

import java.util.HashMap;
import java.util.Map;

public class UsuarioVip extends Usuario {
    private Map<String, Playlist> playlists;

    public UsuarioVip(String id, String email, String username, String password) {
        super(id, email, username, password);
        this.playlists = new HashMap<>();
    }

    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }

    public void createPlaylist(String playlistName) {
        Playlist playlist = new Playlist();
        playlists.put(playlistName, playlist);
    }
}
