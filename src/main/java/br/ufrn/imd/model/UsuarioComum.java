package br.ufrn.imd.model;

public class UsuarioComum extends Usuario {
    private String directory;

    public UsuarioComum(Integer id, String email, String username, String password) {
        super(id, email, username, password);
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
