package Modelo;

public class Producto {
    private int idProd;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;

    //constructor vacio 
    public Producto() {
    }

    //constructor inicializado

    public Producto(int idProd, String descripcion, double precio, int stock, String categoria) {
        this.idProd = idProd;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
    
    //getter y setter
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
}   
