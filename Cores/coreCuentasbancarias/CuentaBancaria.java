// package clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    // variables
    private double saldo;
    private Persona titular = new Persona();
    private  int numeroCuenta;
    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    // Constructor
    public CuentaBancaria(double saldoInicial, Persona titular){
        this.saldo = saldoInicial;
        this.titular = titular;
        this.numeroCuenta = generarNumeroCuenta();
        listaDeCuentasBancarias.add(this);
    }
    // Generar un numero de cuenta aleatorio de 6 dígitos
    public int generarNumeroCuenta(){
        Random random =  new Random();
        // como el ejemplo de clases pero ahora con 6 digitos
        return 100000 + random.nextInt(900000);
    }

    // Métodos getters
    public double getSaldo(){
        return saldo;
    }
    public Persona getTitular(){
        return titular;
    }
    public int getNumeroCuenta(){
        return numeroCuenta;
    }

    // Métodos setters
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public void setTitular(Persona titular){
        this.titular = titular;
    }

    // Método depositar: Añade el monto especificado al saldo de la cuenta.
    public void depositar(double montoDeposito){
        saldo = saldo + montoDeposito;
    }

    //Método retirar: retira el monto especificado al saldo de la cuenta si hay suficientes fondos.
    public void retirar(double montoRetiro){
        if (saldo >= montoRetiro) {
            saldo = saldo - montoRetiro;
        }else{
            System.out.println("No tienes saldo suficiente para reirar tu salfo maximo a retirar es: ");
        }
    }
     // Método de despliega informacion: Muestra la información de la cuenta incluyendo la información del titular.
    public String despliegaInformacion(){
        return "NOMBRE DEL TITULAR: " + titular.getNombre() + " EDAD DEL TITULAR: " + titular.getEdad() + " NUMERO DE CTA: " + numeroCuenta + " SALDO: " + saldo;
    }
    // Método imprimeInformacionDeTodasLasCuentas(): Método estático que recorre la lista de cuentas bancarias e imprime su información.
    public void getListaDeCuentasBancarias(){
        for(int i = 0; i < listaDeCuentasBancarias.size(); i++){
            System.out.println(listaDeCuentasBancarias.get(i).despliegaInformacion());
        }
    }
}
