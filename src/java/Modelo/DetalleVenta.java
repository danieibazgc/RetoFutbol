package Modelo;

public class DetalleVenta {
    private int idVenta;
    private String numSerie;
    private String fecha;
    private String nomCliente;
    private String apellCliente;
    private double montoTotal;
    
    private String descripcion;
    private String categoria;
    private int cantidadProd;
    private double precioProd;
    private double subtotalProd;
    
    // Contructor vacio
    
    public DetalleVenta() {
    }
    
    // Contructor
    public DetalleVenta(int idVenta, String numSerie, String fecha, String nomCliente, String apellCliente, double montoTotal, String descripcion, String categoria, int cantidadProd, double precioProd, double subtotalProd) {
        this.idVenta = idVenta;
        this.numSerie = numSerie;
        this.fecha = fecha;
        this.nomCliente = nomCliente;
        this.apellCliente = apellCliente;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cantidadProd = cantidadProd;
        this.precioProd = precioProd;
        this.subtotalProd = subtotalProd;
    }
    
    //getter y setter

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApellCliente() {
        return apellCliente;
    }

    public void setApellCliente(String apellCliente) {
        this.apellCliente = apellCliente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public double getSubtotalProd() {
        return subtotalProd;
    }

    public void setSubtotalProd(double subtotalProd) {
        this.subtotalProd = subtotalProd;
    }
    
    
    
}
