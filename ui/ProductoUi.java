package ui;

import java.util.List;
import java.util.Scanner;

import exception.ProductoNoEncontradoException;
import model.Producto;
import service.ProductoService;
import util.InputUtil;

public class ProductoUI {

    private Scanner scanner;
    private ProductoService productoService;

    // Constructor de ProductoUI
    public ProductoUI(
            Scanner scanner,
            ProductoService productoService) {

        this.scanner = scanner;
        this.productoService = productoService;
    }

    // Método principal de la interfaz
    public void iniciar() {

        int opcionSeleccionada;

        do {

            mostrarMenu();

            opcionSeleccionada = InputUtil.leerEntero(
                scanner,
                "Seleccione una opción: "
            );

            switch (opcionSeleccionada) {

                case 1:
                    crearProducto();
                    break;

                case 2:
                    listarProductos();
                    break;

                case 3:
                    buscarProducto();
                    break;

                case 4:
                    actualizarProducto();
                    break;

                case 5:
                    eliminarProducto();
                    break;

                case 0:
                    System.out.println(
                        "Saliendo del sistema..."
                    );
                    break;

                default:
                    System.out.println(
                        "La opción seleccionada no es válida."
                    );
            }

        } while (opcionSeleccionada != 0);
    }

    // Muestra las opciones disponibles para el usuario
    private void mostrarMenu() {

        System.out.println();
        System.out.println("================================");
        System.out.println("       GESTIÓN DE PRODUCTOS     ");
        System.out.println("================================");
        System.out.println("1. Crear producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("0. Salir");
        System.out.println("================================");
    }

    // Crea un nuevo producto
    private void crearProducto() {

        System.out.println();
        System.out.println("===== CREAR PRODUCTO =====");

        String nombreProducto = InputUtil.leerTexto(
            scanner,
            "Ingrese el nombre del producto: "
        );

        double precioProducto = InputUtil.leerDecimal(
            scanner,
            "Ingrese el precio del producto: "
        );

        int stockProducto = InputUtil.leerEntero(
            scanner,
            "Ingrese el stock del producto: "
        );

        String categoriaProducto = InputUtil.leerTexto(
            scanner,
            "Ingrese la categoría del producto: "
        );

        // Creamos el objeto Producto con los datos ingresados
        Producto productoNuevo = new Producto(
            nombreProducto,
            precioProducto,
            stockProducto,
            categoriaProducto
        );

        // Enviamos el producto al Service
        productoService.crearProducto(productoNuevo);

        System.out.println();
        System.out.println(
            "Producto creado correctamente."
        );
        System.out.println(
            "ID asignado: " + productoNuevo.getId()
        );
    }

    // Muestra todos los productos registrados
    private void listarProductos() {

        System.out.println();
        System.out.println("===== LISTA DE PRODUCTOS =====");

        List<Producto> listaProductos =
            productoService.listarProductos();

        if (listaProductos.isEmpty()) {

            System.out.println(
                "No hay productos registrados."
            );

            return;
        }

        for (Producto productoActual : listaProductos) {

            System.out.println(productoActual);
        }
    }

    // Busca un producto utilizando su ID
    private void buscarProducto() {

        System.out.println();
        System.out.println("===== BUSCAR PRODUCTO =====");

        int idProductoBuscado = InputUtil.leerEntero(
            scanner,
            "Ingrese el ID del producto: "
        );

        try {

            Producto productoEncontrado =
                productoService.buscarProducto(idProductoBuscado);

            System.out.println();
            System.out.println("Producto encontrado:");
            System.out.println(productoEncontrado);

        } catch (ProductoNoEncontradoException excepcionProductoNoEncontrado) {

            System.out.println();
            System.out.println(
                excepcionProductoNoEncontrado.getMessage()
            );
        }
    }

    // Actualiza los datos de un producto existente
    private void actualizarProducto() {

        System.out.println();
        System.out.println("===== ACTUALIZAR PRODUCTO =====");

        int idProductoAActualizar = InputUtil.leerEntero(
            scanner,
            "Ingrese el ID del producto que desea actualizar: "
        );

        String nuevoNombreProducto = InputUtil.leerTexto(
            scanner,
            "Ingrese el nuevo nombre: "
        );

        double nuevoPrecioProducto = InputUtil.leerDecimal(
            scanner,
            "Ingrese el nuevo precio: "
        );

        int nuevoStockProducto = InputUtil.leerEntero(
            scanner,
            "Ingrese el nuevo stock: "
        );

        String nuevaCategoriaProducto = InputUtil.leerTexto(
            scanner,
            "Ingrese la nueva categoría: "
        );

        try {

            productoService.actualizarProducto(
                idProductoAActualizar,
                nuevoNombreProducto,
                nuevoPrecioProducto,
                nuevoStockProducto,
                nuevaCategoriaProducto
            );

            System.out.println();
            System.out.println(
                "Producto actualizado correctamente."
            );

        } catch (ProductoNoEncontradoException excepcionProductoNoEncontrado) {

            System.out.println();
            System.out.println(
                excepcionProductoNoEncontrado.getMessage()
            );
        }
    }

    // Elimina un producto utilizando su ID
    private void eliminarProducto() {

        System.out.println();
        System.out.println("===== ELIMINAR PRODUCTO =====");

        int idProductoAEliminar = InputUtil.leerEntero(
            scanner,
            "Ingrese el ID del producto que desea eliminar: "
        );

        try {

            productoService.eliminarProducto(
                idProductoAEliminar
            );

            System.out.println();
            System.out.println(
                "Producto eliminado correctamente."
            );

        } catch (ProductoNoEncontradoException excepcionProductoNoEncontrado) {

            System.out.println();
            System.out.println(
                excepcionProductoNoEncontrado.getMessage()
            );
        }
    }
}