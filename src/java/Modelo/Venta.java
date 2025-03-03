package Modelo;

import java.time.LocalDateTime;

public class Venta {

    private int idVenta;
    private int idClienteVenta;
    private int idEmpleadoVenta;
    private String fecha;
    private double totalventa;
    private String numeroserie;

    private int idDetalleVenta;
    private int item;
    private int idProducto;
    private String descripcionProd;
    private int cantProd;
    private double precioProd;
    private double subtotal;

    //contructor vacio
    public Venta() {
    }

    public Venta(int idVenta, int idClienteVenta, int idEmpleadoVenta, String fecha, double totalventa, String numeroserie, int idDetalleVenta, int item, int idProducto, String descripcionProd, int cantProd, double precioProd, double subtotal) {
        this.idVenta = idVenta;
        this.idClienteVenta = idClienteVenta;
        this.idEmpleadoVenta = idEmpleadoVenta;
        this.fecha = fecha;
        this.totalventa = totalventa;
        this.numeroserie = numeroserie;
        this.idDetalleVenta = idDetalleVenta;
        this.item = item;
        this.idProducto = idProducto;
        this.descripcionProd = descripcionProd;
        this.cantProd = cantProd;
        this.precioProd = precioProd;
        this.subtotal = subtotal;
    }

    
    
    
    //getter y setter

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdClienteVenta() {
        return idClienteVenta;
    }

    public void setIdClienteVenta(int idClienteVenta) {
        this.idClienteVenta = idClienteVenta;
    }

    public int getIdEmpleadoVenta() {
        return idEmpleadoVenta;
    }

    public void setIdEmpleadoVenta(int idEmpleadoVenta) {
        this.idEmpleadoVenta = idEmpleadoVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(double totalventa) {
        this.totalventa = totalventa;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    

}
