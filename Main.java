import java.util.Scanner;

import service.ProductoService;
import ui.ProductoUI;

public class Main {

    public static void main(String[] args) {

        // Creamos el Scanner para leer información del usuario
        Scanner scanner = new Scanner(System.in);

        // Creamos el Service que se encargará de gestionar los productos
        ProductoService productoService = new ProductoService();

        // Creamos la interfaz de usuario y le pasamos
        // el Scanner y el ProductoService
        ProductoUI productoUI = new ProductoUI(
            scanner,
            productoService
        );

        // Iniciamos el menú principal del sistema
        productoUI.iniciar();

        // Cerramos el Scanner cuando terminamos el programa
        scanner.close();
    }
}