package br.ufrn.imd.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Musica;

public class Diretorio {
    public Musica fileToMusica(File f) {
        Musica musica = new Musica();
        musica.setName(f.getName());
        musica.setDiretorio(f.getAbsolutePath());
        return musica;
    }

    public List<Musica> buscaMusica(String diretorio) {
        List<Musica> musicas = new ArrayList<>();

        File file = new File(diretorio);

        File[] arquivos = file.listFiles();

        if (arquivos != null) {  
            for(File f: arquivos) {
                if(f.isFile() && f.getName().toLowerCase().endsWith(".mp3")){
                    musicas.add(fileToMusica(f));
                }
            }
        } else {
            System.out.println("O diretório não existe ou não é um diretório válido.");
        }

        return musicas;
    }

    public void criarDiretorio(String nome) throws IOException {
        String dir = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\playlists\\" + nome + ".txt";

        //verifica se o diretório existe

        BufferedWriter writer = new BufferedWriter(new FileWriter(dir));
    }
}
