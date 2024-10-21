//package BOOTCAMP.2JAVA.ActividadesYCoresJAVA.Biblioteca.CLASES;
public class Libros {
    private String titulo;
    private String autor;
    private double precioReemplazo;

    public Libros(String titulo, String autor, double precioReemplazo){
        this.titulo = titulo;
        this.autor = autor;
        this.precioReemplazo = precioReemplazo;
    }
    //Getters
    public String getAutor() {
        return autor;
    }
    public double getPrecioReemplazo() {
        return precioReemplazo;
    }
    public String getTitulo() {
        return titulo;
    }
    //Setters
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setPrecioReemplazo(double precioReemplazo) {
        this.precioReemplazo = precioReemplazo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        return "Titulo: " + getTitulo() + " ,Precio reemplazo: " + getPrecioReemplazo() + " ,Autor: " + getAutor() ;
    }
}
