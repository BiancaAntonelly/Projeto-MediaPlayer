package br.ufrn.imd.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;
public class PlayerMusica {
    private File musica;
    private Player player;
    private boolean isPause = false;

    public PlayerMusica(File musica){
        this.musica = musica;
    }

    public void play(){
        new Thread(() -> {
            try {
                FileInputStream fileInputStream = new FileInputStream(musica);
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
}
