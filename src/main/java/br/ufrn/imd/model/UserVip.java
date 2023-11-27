package br.ufrn.imd.model;

import java.util.HashMap;
import java.util.Map;

public class UserVip extends User{
    private Map<String, Playlist> playlists;

    public UserVip(String name, String email, String username, String password) {
        super(name, email, username, password);
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
