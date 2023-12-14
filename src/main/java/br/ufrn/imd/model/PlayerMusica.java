package br.ufrn.imd.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javazoom.jl.player.Player;
public class PlayerMusica {
    private Musica musica;
    private Player player;
    private boolean isPause = false;
    private int pos = 0;

    public void play(){
        pause();
        new Thread(() -> {
            try {
                FileInputStream fileInputStream = new FileInputStream(musica.getDiretorio());
                BufferedInputStream buffer = new BufferedInputStream(fileInputStream);
                this.player = new Player(buffer);
                System.out.println("Iniciando a música...");
                this.player.play();
                System.out.println("Terminado a música");
            } catch (Exception e) {
                System.out.println("Erro!");
                e.printStackTrace();
            }
        }).start();
    }

    public void pause() {
        if(player != null) {
            try {
                player.close();
                isPause = true;
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("Não foi possível pausar a música");
            }
        }
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    /*
    public void next() {
        if(player != null) {
           try {
                new Thread(() -> {
                    player.close();
                    pos++;
                    musica = musicas.get(pos);
                    play();
                }).start();
           } catch (Exception e){
                e.printStackTrace();
                System.out.println("Não foi possível avançar para a próxima música");
           } 
        }
    }

    public void previous() {
        if(player != null) {
            try {
                new Thread(() -> { 
                    player.close();
                    pos--;
                    musica = musicas.get(pos);
                    play();
               }).start();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("Não foi possível voltar para a música anterior");
            }
        }
    } */
}