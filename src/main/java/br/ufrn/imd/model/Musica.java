package br.ufrn.imd.model;

public class Musica {
    private String name, diretorio, id, idPlayList;
    private float tempo;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDiretorio() {
        return diretorio;
    }
    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdPlayList() {
        return idPlayList;
    }
    public void setIdPlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }
    public float getTempo() {
        return tempo;
    }
    public void setTempo(float tempo) {
        this.tempo = tempo;
    }
}