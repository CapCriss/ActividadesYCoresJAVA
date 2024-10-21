


public class Aplicacion {
    
    public static void main(String[] args) {
        int num1 = 5;
        System.out.println(Algoritmos.esPar(num1)); // ok
        int num2 = 7;
        System.out.println(Algoritmos.esPrimo(num2)); // ok
        String  string = "hola";
        System.out.println(Algoritmos.stringEnReversaString(string)); //ok
        // esPalindromo
        String string1 = "Anita lava la tina"; // ok ("Radar" = tambien es un palindromo)
        System.out.println(Algoritmos.esPalindromo(string1));

        // secuenciaFizzBuzz:
        int pruebaFizzBuzz = 15;
        System.out.println("prueba secuencia FizzBuzz con 15: ");
        Algoritmos.secuenciaFizzBuzz(pruebaFizzBuzz);
        
        
    }
}
