package br.ufrn.imd;

import java.io.IOException;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import br.ufrn.imd.model.Musica;
import br.ufrn.imd.service.Diretorio;

public class Teste {
    public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        Diretorio diretorio = new Diretorio();
        List<Musica> musicas = diretorio.buscaMusica("C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\resources\\br.ufrn.imd\\musicas");

        for(Musica m: musicas) {
            System.out.println(m.getName() + " " + m.getDiretorio());
        }
    }
}
