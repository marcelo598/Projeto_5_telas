package br.com.projeto.model;

public class Usuario {
    private String senha;
    private boolean status;
    private String perfil;
    private String login;
    private int id;

    public Usuario(int id ,String login, String senha, boolean status,
    String perfil) {
        this.id=id;
        this.login=login;
        this.senha=senha;
        this.status=status;
        this.perfil=perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
