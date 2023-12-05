package Patrones_Diseño.ChainOfResponsibility;

import java.util.Scanner;

public class OperarCajero {
    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico(1000000); //Asignación de saldo disponible

        Integer saldo = cajero.consultarSaldoDisponible(); // Saldo Inicial

        Scanner scanner = new Scanner(System.in);

        HandlerBilletes handler100000 = new HandlerBillete100000();
        HandlerBilletes handler50000 = new HandlerBillete50000();
        HandlerBilletes handler20000 = new HandlerBillete20000();
        HandlerBilletes handler10000 = new HandlerBillete10000();
        HandlerBilletes handler5000 = new HandlerBillete5000();

        handler100000.establecerSiguiente(handler50000);
        handler50000.establecerSiguiente(handler20000);
        handler20000.establecerSiguiente(handler10000);
        handler10000.establecerSiguiente(handler5000);

        cajero.establecerManejadorInicio(handler100000);

        while (true) {
            System.out.println("*********************************************");
            System.out.println(" .::: BIENVENIDO A SU CAJERO AUTOMATICO :::.");
            System.out.println("*********************************************");
            System.out.println();
            System.out.println("Que operacion desea realizar:\n");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Salir \n");
            System.out.print("Seleccione una opcion: ");

            Integer opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo disponible: $" + saldo + "\n");
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: $");
                    Integer cantidadARetirar = scanner.nextInt();
                    if ((saldo - cantidadARetirar) > 0) {
                        if (cantidadARetirar % 5000 != 0) {
                            System.out.println("\nNuestro sistema no puede procesar la cantidad de dinero ingresada.\n");
                        } else {
                            System.out.println("Cajero operando...");
                            cajero.retirarDinero(cantidadARetirar);
                            saldo -= cantidadARetirar; //Actualiza el saldo en la cuenta
                            System.out.println("\nNuevo saldo disponible: $" + saldo + "\n");
                        }
                    } else {
                        System.out.println("Saldo Insuficiente. \n");
                    }
                    break;
                case 3:
                    System.out.println("Gracias por utilizar nuestros servicios. Hasta pronto!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Incorrecta. Por favor, seleccione una opcion valida.");
            }
        }
    }
}
