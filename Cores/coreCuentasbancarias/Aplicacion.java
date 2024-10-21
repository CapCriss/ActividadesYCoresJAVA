// import clases.Persona;
// import clases.CuentaBancaria;

public class Aplicacion {
    public static void main(String[] args) {
        Persona titular1 = new Persona("Cristian", 23);
        Persona titular2 = new Persona("Andres", 23);
        Persona titular3 = new Persona("Ana", 24);

        CuentaBancaria cta1 = new CuentaBancaria(10000, titular1);
        CuentaBancaria cta2 = new CuentaBancaria(10000, titular2);
        CuentaBancaria cta3 = new CuentaBancaria(10000, titular3);

        // System.out.println(titular1.despliegaInformacion());
        // System.out.println(titular2.despliegaInformacion());
        // System.out.println(titular3.despliegaInformacion());
        // System.out.println(cta1.despliegaInformacion());
        // System.out.println(cta2.despliegaInformacion());
        // System.out.println(cta3.despliegaInformacion());
        cta1.depositar(10000);
        System.out.println(cta1.getSaldo());
        cta1.retirar(15000);
        System.out.println(cta1.getSaldo());
        cta1.retirar(6000);
        System.out.println(cta1.getSaldo());
        cta1.getListaDeCuentasBancarias();
    }
}
