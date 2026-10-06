package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductoService {

    private List<Producto> productos;

    public ProductoService(){
        productos = new ArrayList<>();
    }
    
    public void crearProducto (Producto producto){

        productos.add (producto);
    }
    
    public List<Producto> listarProducto(){
        return productos;
    }
    
    //buscarProducto
    
    //actualizarProducto()
    
    //eliminarProducto()
    
}




