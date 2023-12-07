package br.ufrn.imd;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import br.ufrn.imd.model.Musica;
import br.ufrn.imd.model.PlayerMusica;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.service.Diretorio;
import br.ufrn.imd.service.GeradorDeId;
import br.ufrn.imd.service.PlayListService;

public class Teste {
    
    public static void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        Diretorio diretorio = new Diretorio();
        List<Musica> musicas = diretorio.diretoriosPorUser("e25ea6d9-a408-4910-bc3b-9d5dba029e78");

        PlayListService playListService = new PlayListService();
        List<Playlist> listas =  playListService.buscarPlayListsPorUser("e25ea6d9-a408-4910-bc3b-9d5dba029e78");


        Playlist playList = new Playlist();
        playList.setMusicas(musicas);

        playList.listarMusicas();

        PlayerMusica playerMusica = new PlayerMusica(playList.getMusicas());
        playerMusica.play();
        
        sleep();
 
        playerMusica.next();
       
    }
}
