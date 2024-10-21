

public class Algoritmos {
    // saber si un numero es par:
    public static boolean esPar(int numero){
        if (numero % 2 == 0) {
            return true;
        }else{
            return false;
        }
    }

    // saber si un numero es primo:
    public static boolean esPrimo(int numero){
        for (int i = numero - 1 ; i >=2; i--){
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    //invertir una cadena:
    public static String stringEnReversaString(String string){
        String inversa = "";

        for (int i = string.length() - 1; i >= 0; i--){
            inversa += string.charAt(i);
        }
        return("la palabra en reversa es: " + inversa);
        
    }
    // saber si es un palindromo:

    public static boolean esPalindromo(String string){
        //primero "normalizo" el string para eliminar los espacios en blanco y dejarlo en minuscula y asi evvitar errores.
        String stringNormalizado = string.replaceAll("\\s", "").toLowerCase();
        //creo un nuevo string escrito al revez con el método Reverse() para ahorrar codigo.
        String reverseString = new StringBuffer(stringNormalizado).reverse().toString();
        //finalmente ocupo equals para comparar el string dado vuelta, con el normalizado si son iguales retorno true, en caso contrario false.
        if (stringNormalizado.equals(reverseString)) {
            return true;
        }else{
            return false;
        }
    }

    // secuencia FizzBuzz
    public static void secuenciaFizzBuzz(int secuencia){
        for ( int i = 1; i <= secuencia; i++ ){

            if (((i % 3) == 0) && ((i % 5) == 0)){
                    System.out.println("FizzBuzz");
            }else if ((i % 3) == 0){
                System.out.println("Fizz");
            }else if ((i % 5) == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
            }
    }

}



