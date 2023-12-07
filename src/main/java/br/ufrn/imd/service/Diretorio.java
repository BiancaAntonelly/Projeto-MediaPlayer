package br.ufrn.imd.service;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Musica;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Diretorio {
    private GeradorDeId geradorDeId = new GeradorDeId();
    public Musica fileToMusica(File f) {
        Musica musica = new Musica();
        musica.setName(f.getName());
        musica.setDiretorio(f.getAbsolutePath());
        return musica;
    }

    public List<Musica> diretoriosPorUser(String idUSer) throws IOException {
        List<Musica> musicas = new ArrayList<>();

        Path path = Paths.get("C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\diretorios.txt");
        List<String> linhas = Files.readAllLines(path);

        for (String linha : linhas) {
            List<String> split = List.of(linha.split(","));
            if(split.get(1).equals(idUSer)){
                Musica musica = new Musica();
                musica.setDiretorio(split.get(1));
                musica.setName(split.get(2));
                musicas.add(musica);
            }
        }

        return musicas;
    }

    public void openDiretorio(String id) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\v_mar\\Music"));
        fileChooser.setDialogTitle("Selecionar Músicas");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Música", "mp3", "wav", "ogg");
        fileChooser.setFileFilter(filter);

        fileChooser.setMultiSelectionEnabled(true);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();

            for (File file : files) {
                addDiretorio(id, file.getAbsolutePath().toString(), file.getName());
            }
        }
    }

    public void addDiretorio(String id, String caminho, String nome) throws IOException {
        String dir = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\diretorios.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir, true))) {
            writer.write(id + "," + caminho + "," + nome);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
