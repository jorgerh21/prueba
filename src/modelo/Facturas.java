/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author jorge
 */
public class Facturas {
    public int idFactura;
    public int NumeroFactura;
    public Date Fecha;
    public String TipoPago;
    public int DocumentoCliente;
    public String NombreCliente;
    public double Subtotal;
    public int Descuento;
    public int Iva;
    public double TotalDescuento;
    public double TotalImpuesto;
    public double Total;

    public Facturas() {
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getNumeroFactura() {
        return NumeroFactura;
    }

    public void setNumeroFactura(int NumeroFactura) {
        this.NumeroFactura = NumeroFactura;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    public int getDocumentoCliente() {
        return DocumentoCliente;
    }

    public void setDocumentoCliente(int DocumentoCliente) {
        this.DocumentoCliente = DocumentoCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public int getIva() {
        return Iva;
    }

    public void setIva(int Iva) {
        this.Iva = Iva;
    }

    public double getTotalDescuento() {
        return TotalDescuento;
    }

    public void setTotalDescuento(double TotalDescuento) {
        this.TotalDescuento = TotalDescuento;
    }

    public double getTotalImpuesto() {
        return TotalImpuesto;
    }

    public void setTotalImpuesto(double TotalImpuesto) {
        this.TotalImpuesto = TotalImpuesto;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "Facturas{" + "idFactura=" + idFactura + ", NumeroFactura=" + NumeroFactura + ", Fecha=" + Fecha + ", TipoPago=" + TipoPago + ", DocumentoCliente=" + DocumentoCliente + ", NombreCliente=" + NombreCliente + ", Subtotal=" + Subtotal + ", Descuento=" + Descuento + ", Iva=" + Iva + ", TotalDescuento=" + TotalDescuento + ", TotalImpuesto=" + TotalImpuesto + ", Total=" + Total + '}';
    }

    
        
}
