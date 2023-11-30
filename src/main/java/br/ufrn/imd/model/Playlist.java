package br.ufrn.imd.model;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.interfaces.PlayListInterface;

public class Playlist implements PlayListInterface {
    private String name, categoria;
    private List<Musica> musicas = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public List<Musica> getMusicas() {
        return musicas;
    }
    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
    @Override
    public void adicionarMusica(Musica musica) {
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