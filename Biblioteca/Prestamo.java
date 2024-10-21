//package CLASES;

import java.util.ArrayList;


public class Prestamo {
    private String nombrePersona;
    private ArrayList<Libros.Libros> libros;
    private boolean estatus;

    public Prestamo(){
    this.nombrePersona = "invitado";
    this.estatus = true;
    this.libros = new ArrayList<Libro>();
    }

    public Prestamo(String nombrePersona, boolean estatus){
        this.nombrePersona = nombrePersona;
        this.estatus = estatus;
        this.libros = new ArrayList<Libro>();
    }

    //Getters
    public ArrayList<Libro> getLibros() {
        return libros;
    }
    public String getNombrePersona() {
        return nombrePersona;
    }
    public boolean getEstatus(){
        return estatus;
    }
    //Setters
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    //Metodos
    public void agregarLibro(Libro libro){
        libros.add(libro);
    }
    public String retornarEstatus(){
        if(estatus){
            return ("El prestamo esta activo ");
        }else{
            return ("El prestamo esta inactivo ");
        }       
    }
    public String mostrarDetalles(){
    return "Nombre persona: " + getNombrePersona() + " ,Estatus: " + getEstatus() + " ,Libros: " + getLibros();
    }
    public double calcularTotal(){
        double total = 0;
        for(int i = 0; i < libros.size(); i++){
            total += libros.get(i).getPrecioReemplazo();
        }
        return total;
    }
}