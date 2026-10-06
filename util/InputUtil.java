package util;

import java.util.Scanner;

public class InputUtil {

    // Lee un texto ingresado por el usuario
    public static String leerTexto(Scanner scanner, String mensaje) {

        System.out.print(mensaje);

        return scanner.nextLine();
    }

    // Lee un número entero ingresado por el usuario
    public static int leerEntero(Scanner scanner, String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                String textoIngresado = scanner.nextLine();

                int numeroEntero = Integer.parseInt(textoIngresado);

                return numeroEntero;

            } catch (NumberFormatException excepcionNumeroInvalido) {

                System.out.println(
                    "Error: debes ingresar un número entero."
                );
            }
        }
    }

    // Lee un número decimal ingresado por el usuario
    public static double leerDecimal(Scanner scanner, String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                String textoIngresado = scanner.nextLine();

                double numeroDecimal = Double.parseDouble(textoIngresado);

                return numeroDecimal;

            } catch (NumberFormatException excepcionNumeroInvalido) {

                System.out.println(
                    "Error: debes ingresar un número válido."
                );
            }
        }
    }
}