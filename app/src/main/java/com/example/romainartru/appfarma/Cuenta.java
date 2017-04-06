package com.example.romainartru.appfarma;

/**
 * Created by romainartru on 06/04/2017.
 */

public class Cuenta {
    private String usuario;
    private String correo;
    private String mdp;

    public Cuenta(String u, String co, String m){
        usuario =u;
        mdp = m;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
