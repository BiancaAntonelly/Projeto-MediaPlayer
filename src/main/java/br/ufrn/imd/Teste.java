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
        List<Musica> musicas = diretorio.buscaMusica("C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\resources\\br.ufrn.imd\\musicas");

        diretorio.criarDiretorio("marcos");

        for(Musica m: musicas) {
            System.out.println(m.getName() + " " + m.getDiretorio());
        }


        Playlist playList = new Playlist();
        playList.setMusicas(musicas);

        playList.listarMusicas();

        PlayerMusica playerMusica = new PlayerMusica(playList.getMusicas());
        playerMusica.play();
        
        sleep();
 
        playerMusica.next();
       
    }
}
