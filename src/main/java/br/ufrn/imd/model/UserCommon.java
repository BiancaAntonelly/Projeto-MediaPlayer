package br.ufrn.imd.model;

public class UserCommon extends User{
    private String directory;

    public UserCommon(String name, String email, String username, String password) {
        super(name, email, username, password);
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
