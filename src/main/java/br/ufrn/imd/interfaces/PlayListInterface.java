package br.ufrn.imd.interfaces;

import br.ufrn.imd.model.Musica;

import java.io.IOException;

public interface PlayListInterface {
    void adicionarMusica(Musica musica) throws IOException;
    Musica buscarMusica(String nome);
    void removerMusica(Musica musica);
    void listarMusicas();
}
