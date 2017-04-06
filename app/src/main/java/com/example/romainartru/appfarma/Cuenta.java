package com.example.romainartru.appfarma;

/**
 * Created by romainartru on 06/04/2017.
 */

public class Cuenta {
    private String usuario;
    private String mdp;

    public Cuenta(String u, String m){
        usuario =u;
        mdp = m;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getMdp() {
        return mdp;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
