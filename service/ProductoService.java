package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductoService {

    private List<Producto> listaProductos;
    private int siguienteId = 1;

    public ProductoService(){
        listaProductos = new ArrayList<>();
    }
    
    // Metodo de creacion de productos
    public void crearProducto (Producto productoNuevo){

        productoNuevo.setId(siguienteId);

        listaProductos.add (productoNuevo);

        siguienteId++;
    }

    // Metodo de listado de productos
    public List<Producto> listarProductos(){
        return listaProductos;
    }

    //Metodo de busqueda por id de producto
    public Producto buscarProducto(int id){
        for (Producto productoActual : listaProductos){
            if (productoActual.getId() == id ){
                return productoActual;
            }
        }

        return null;

    }
    
    // Metodo de actualizacion de producto por ID
    public void actualizarProducto(
        int id, String nombre, double precio, int stock, String categoria){

            Producto productoEncontrado = buscarProducto(id);

            if(productoEncontrado != null) {

                productoEncontrado.setNombre(nombre);
                productoEncontrado.setPrecio(precio);
                productoEncontrado.setStock(stock);
                productoEncontrado.setCategoria(categoria);

            } 

        }
    
    //Metodo de eliminacion de producto por ID    
    public void eliminarProducto( int id){

        Producto productoEncontrado = buscarProducto(id);

        if (productoEncontrado != null){
            listaProductos.remove(productoEncontrado);
        }
    }
    
}




