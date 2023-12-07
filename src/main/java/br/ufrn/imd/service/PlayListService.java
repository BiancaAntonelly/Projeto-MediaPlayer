package br.ufrn.imd.service;

import br.ufrn.imd.model.Musica;
import br.ufrn.imd.model.Playlist;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayListService {
    public void criarPlayList(String nome, String id) throws IOException {
        String dir = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\playlists\\" + "playlist_" + nome + "_" + id + ".txt";

        //verifica se o diretório existe

        BufferedWriter writer = new BufferedWriter(new FileWriter(dir));
    }

    public List<Playlist> buscarPlayListsPorUser(String idUser) {
        List<Playlist> playlists = new ArrayList<>();
        String dir = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\playlists";

        File file = new File(dir);

        if(file.isDirectory()){
            File[] arquivos = file.listFiles();

            if(arquivos != null) {
                for (int i = 0; i < arquivos.length; i++) {
                    if (arquivos[i].isFile() && arquivos[i].getName().endsWith(".txt")) {
                        List<String> split = List.of(arquivos[i].getName().split("_"));
                        if(split.get(2).contains(idUser)) {
                            playlists.add(lerMusicas(arquivos[i].getAbsolutePath(), split.get(1), idUser));
                        }
                    }
                }
            }
            System.out.println("Li todas musicas");
        }

        return playlists;
    }

    public Playlist lerMusicas(String caminho, String nome, String idUser) {
        Playlist playlist = new Playlist();
        File file = new File(caminho);
        playlist.setName(nome);
        playlist.setIdUsuario(idUser);
        playlist.setCaminho(caminho);

        if(file.exists())  {

            try (BufferedReader leitor = new BufferedReader(new FileReader(file))) {
                String linha;
                while ((linha = leitor.readLine()) != null) {

                    List<String> split = List.of(linha.split(","));
                    Musica m = new Musica();
                    m.setId(split.get(0));
                    m.setDiretorio(split.get(1));
                    m.setName(split.get(2));

                    System.out.println("id: " + split.get(0) + "dir: "+ split.get(1) + "nome: " + split.get(2));
                    playlist.adicionarMusica(m);
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }
        return playlist;
    }

    public List<Musica> addMusica(String caminho, String idUser) throws IOException {
        List<Musica> musicas = new ArrayList<>();

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
            musicas = criaMusicas(files, caminho, idUser);
        }
        return musicas;
    }

    public List<Musica> criaMusicas(File[] files, String nome, String idUser) throws IOException {
        List<Musica> musicas = new ArrayList<>();
        Musica m = new Musica();
        String caminho = "playlist_"+ nome + "_" + idUser;
        for (File file: files) {
            m.setName(file.getName());
            m.setDiretorio(file.getAbsolutePath());
            m.setId(idUser);
            musicas.add(m);
            updatePlayList(file.getAbsolutePath(), caminho, idUser, file.getName());
            System.out.println("caminho: "+ caminho);
        }

        return musicas;
    }
    public void updatePlayList(String caminhoMusica, String caminho, String id, String nome) throws IOException {
        String dir = "C:\\Users\\v_mar\\Desktop\\MediaPlayer\\Projeto-MediaPlayer\\src\\main\\java\\br\\ufrn\\imd\\txt\\playlists\\" + caminho + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir, true))) {
            writer.write(id + "," + caminhoMusica + "," + nome);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
