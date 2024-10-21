//package BOOTCAMP.2JAVA.ActividadesYCoresJAVA.Biblioteca;

// import clases.Libro;
// import clases.Prestamo;

public class Aplicacion {
    public static void main(String[] args) {

        Libro.Libros libro1 = new Libros.Libros("Ella y yo", "Romeo Santos", 12.45);
        Libro libro2 = new Libros("El Farsante", "Ozuna", 9.44);
        
        Prestamo prestamo1 = new Prestamo();
        Prestamo prestamo2 = new Prestamo();
        Prestamo prestamo3 = new Prestamo("Lupita", true);
        Prestamo prestamo4 = new Prestamo("Juan", true);
        Prestamo prestamo5 = new Prestamo("Felipe", true);

        prestamo3.agregarLibro(libro1);
        prestamo3.agregarLibro(libro2);
        System.out.println(prestamo3.mostrarDetalles());
    }
}