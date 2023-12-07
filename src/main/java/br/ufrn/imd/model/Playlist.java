package br.ufrn.imd.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.interfaces.PlayListInterface;
import br.ufrn.imd.service.PlayListService;

public class Playlist implements PlayListInterface {
    private String name, caminho, id, idUsuario;
    private List<Musica> musicas = new ArrayList<>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCaminho() {
        return caminho;
    }
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
    @Override
    public void adicionarMusica(Musica musica) throws IOException {
        musicas.add(musica);
    }

    @Override
    public Musica buscarMusica(String nome) {
        for (Musica musica : musicas) {
            if (musica.getName().equals(nome)) {
                return musica;
            }
        }
        return null;
    }

    @Override
    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    @Override
    public void listarMusicas() {
        System.out.println("Lista de músicas");
        for(Musica m: musicas) {
            System.out.println("Nome: " + m.getName());
        }
    }
}