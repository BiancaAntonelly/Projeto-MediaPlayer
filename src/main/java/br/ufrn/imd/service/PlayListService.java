package br.ufrn.imd.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PlayListService {
    public void criarPlayList(String nome) throws IOException {
        String dir = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\playlists\\" + nome + ".txt";

        //verifica se o diretório existe

        BufferedWriter writer = new BufferedWriter(new FileWriter(dir));
    }

    public void buscarMusicas(String idUser) {

    }
}
