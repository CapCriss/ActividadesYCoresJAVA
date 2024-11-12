package com.curso.springboot.vs.spring_vs.modelos;

import java.time.LocalDateTime;

public class messageDto {
    private LocalDateTime tiempo;
    private String mensaje;
    public LocalDateTime getTiempo() {
        return tiempo;
    }
    public messageDto(LocalDateTime tiempo, String mensaje) {
        this.tiempo = tiempo;
        this.mensaje = mensaje;
    }
    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public messageDto() {
    }


}
