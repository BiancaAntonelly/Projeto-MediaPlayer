package br.ufrn.imd.interfaces;

import br.ufrn.imd.model.Musica;

public interface PlayListInterface {
    void adicionarMusica(Musica musica);
    Musica buscarMusica(String nome);
    void removerMusica(Musica musica);
}