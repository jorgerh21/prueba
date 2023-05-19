/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jorge
 */
public class Productos {
    public int idProducto;
    public String Producto;

    public Productos() {
    }

    public Productos(String Producto) {
        this.Producto = Producto;
    }

    public Productos(int idProducto, String Producto) {
        this.idProducto = idProducto;
        this.Producto = Producto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    @Override
    public String toString() {
        return "Productos{" + "idProducto=" + idProducto + ", Producto=" + Producto + '}';
    }
    
    
}
