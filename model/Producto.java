package model;

public class Producto {
    
    //Atributos de la clase Producto
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    
    // Constructores
    public Producto (String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    //Constructor vacio 
    public Producto() {
    }

    // Getters y Setters para acceder y modificar los atributos de la clase Producto

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método toString para representar el objeto Producto como una cadena de texto
    @Override
    public String toString() {
        return "ID: " + id +
         "|" + nombre +
         "|" + precio +
         "|" + stock +
         "|" + categoria;
    }
}
