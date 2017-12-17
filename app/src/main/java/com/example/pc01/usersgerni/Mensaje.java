package com.example.pc01.usersgerni;

/**
 * Created by rafae on 17/12/2017.
 */

public class Mensaje {
    private String mensaje;
    private String nombre;
    private String fotPefil;
    private String type_men;
    private String hora;

    public Mensaje() {
    }

    public Mensaje(String mensaje, String nombre, String fotPefil, String type_men, String hora) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.fotPefil = fotPefil;
        this.type_men = type_men;
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotPefil() {
        return fotPefil;
    }

    public void setFotPefil(String fotPefil) {
        this.fotPefil = fotPefil;
    }

    public String getType_men() {
        return type_men;
    }

    public void setType_men(String type_men) {
        this.type_men = type_men;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
