package br.ufrn.imd.model;

public class Musica {
    private String name, diretorio;
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
    public float getTempo() {
        return tempo;
    }
    public void setTempo(float tempo) {
        this.tempo = tempo;
    }
}