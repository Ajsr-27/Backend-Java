package service;

import java.util.ArrayList;
import java.util.List;
import exception.ProductoNoEncontradoException;

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
    public Producto buscarProducto(int id)
        throws ProductoNoEncontradoException {

        for (Producto productoActual : listaProductos){
            if (productoActual.getId() == id ){
                return productoActual;
            }
        }

        throw new ProductoNoEncontradoException(
        "El producto con ID " + id + " no existe.");
    }
    
    // Metodo de actualizacion de producto por ID
    public void actualizarProducto(
        int id, String nombre, double precio, int stock, String categoria)
        throws ProductoNoEncontradoException {

            Producto productoEncontrado = buscarProducto(id);

            productoEncontrado.setNombre(nombre);
            productoEncontrado.setPrecio(precio);
            productoEncontrado.setStock(stock);
            productoEncontrado.setCategoria(categoria);


        }
    
    //Metodo de eliminacion de producto por ID    
    public void eliminarProducto( int id)throws ProductoNoEncontradoException {

        Producto productoEncontrado = buscarProducto(id);

        listaProductos.remove(productoEncontrado);
        
    }
    
}




