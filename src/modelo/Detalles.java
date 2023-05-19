/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jorge
 */
public class Detalles {
    public int idDetalle;
    public int idProducto;
    public int idFactura;
    public int Cantidad;
    public double PrecioUnitario;

    public Detalles() {
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    @Override
    public String toString() {
        return "Detalles{" + "idDetalle=" + idDetalle + ", idProducto=" + idProducto + ", idFactura=" + idFactura + ", Cantidad=" + Cantidad + ", PrecioUnitario=" + PrecioUnitario + '}';
    }

   
    
    
}
