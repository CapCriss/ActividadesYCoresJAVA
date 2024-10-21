// package clases;

public class Persona {
    // variables nombre y edad de la persona.
    private String nombre;
    private int edad = 0;
    
    // CONSTRUCTOR
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public Persona(){
    }
    // Métodos getters
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    // Métodos setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void SetEdad(int edad){
        this.edad = edad;
    }
    // Método de desplegar informacion
    public String despliegaInformacion(){
        return "NOMBRE: " + nombre + " EDAD: " + edad;
    }
}