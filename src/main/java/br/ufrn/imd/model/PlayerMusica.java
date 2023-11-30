package br.ufrn.imd.model;

import java.io.FileInputStream;
import java.util.Optional;
//import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class PlayerMusica {
    Musica musica = new Musica();

    public void tocarMusica() {
        try {
            var fileInputStream = new FileInputStream(musica.getDiretorio());
           // var Player = new Player(fileInputStream);
           // this.player = Optional.of(player);

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
