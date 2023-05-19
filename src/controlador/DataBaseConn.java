/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Facturas;
import java.sql.PreparedStatement;
import java.sql.Date;
import modelo.Detalles;
import modelo.Productos;
/**
 *
 * @author jorge
 */
public class DataBaseConn {
    
    
    public void conection() throws ClassNotFoundException{
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 10 * from Productos";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
    public List<Facturas> mostrarFacturas() throws ClassNotFoundException{
        List<Facturas> facturas = new ArrayList();
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from Facturas";
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement
            int i=0;
            while (resultSet.next()) {
                Facturas factura = new Facturas();
                factura.idFactura = resultSet.getInt(1);
                factura.Fecha = resultSet.getDate(3);
                factura.NumeroFactura = resultSet.getInt(2);
                factura.NombreCliente = resultSet.getString(6);
                factura.Total = resultSet.getDouble(12);
                facturas.add(factura);
                i++;
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(6));
            }
            return facturas;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return facturas;
    }
    
    public List<Productos> ListarProductos() throws ClassNotFoundException{
        List<Productos> productos = new ArrayList();
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from Productos";
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement
            while (resultSet.next()) {
                Productos producto = new Productos();
                producto.idProducto = resultSet.getInt(1);
                producto.Producto = resultSet.getString(2);
                productos.add(producto);
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
            return productos;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return productos;
    }
    
    public List<Detalles> ListarDetalles(int id) throws ClassNotFoundException{
        List<Detalles> detalles = new ArrayList();
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from Detalles where idFactura=" + id;
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement
            while (resultSet.next()) {
                Detalles detalle = new Detalles();
                detalle.idDetalle = resultSet.getInt(1);
                detalle.idFactura = resultSet.getInt(2);
                detalle.idProducto = resultSet.getInt(3);
                detalle.Cantidad = resultSet.getInt(4);
                detalle.PrecioUnitario = resultSet.getDouble(5);
                detalles.add(detalle);
            }
            return detalles;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return detalles;
    }
    
    public Facturas MostrarFactura(int id) throws ClassNotFoundException{
         //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Facturas factura = new Facturas();
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from Facturas where idFactura=" + id;
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement
            while (resultSet.next()) {
                
                factura.idFactura = resultSet.getInt(1);
                factura.NumeroFactura = resultSet.getInt(2);
                factura.Fecha = resultSet.getDate(3);
                factura.TipoPago = resultSet.getString(4);
                factura.DocumentoCliente = resultSet.getInt(5);
                factura.NombreCliente = resultSet.getString(6);
                factura.Subtotal = resultSet.getDouble(7);
                factura.Descuento = resultSet.getInt(8);
                factura.Iva = resultSet.getInt(9);
                factura.TotalDescuento = resultSet.getDouble(10);
                factura.TotalImpuesto = resultSet.getDouble(11);
                factura.Total = resultSet.getDouble(12);
                
            }
            return factura;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return factura;
    }
    
    public int insertarFactura(Facturas f) throws ClassNotFoundException{
     //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        
        int idFactura =f.getIdFactura();
        int NumeroFactura =f.getNumeroFactura();
        Date Fecha = new Date(2020,12,12);
        String TipoPago =f.getTipoPago();
        int DocumentoCliente =f.getDocumentoCliente();
        String NombreCliente =f.getNombreCliente();
        double Subtotal =f.getSubtotal();
        int Descuento =f.getDescuento();
        int Iva=f.getIva();
        double TotalDescuento=f.getTotalDescuento();
        double TotalImpuesto=f.getTotalImpuesto();
        double Total=f.getTotal();

        String insertSql = "INSERT INTO Facturas ( NumeroFactura, Fecha,TipodePago ,DocumentoCliente ,NombreCliente, Subtotal, Descuento, IVA, TotalDescuento, TotalImpuesto,Total ) VALUES "
                + "( "+ NumeroFactura +", '"+ Fecha +"', '"+ TipoPago +"', "+ DocumentoCliente +", '"+ NombreCliente +"' , "+ Subtotal +", "+ Descuento +", "+ Iva +", "+ TotalDescuento +", "+ TotalImpuesto +", "+ Total +");";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
                return Integer.parseInt(resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
     public void actualizarFactura(Facturas f, int id) throws ClassNotFoundException{
     //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        
        int idFactura =f.getIdFactura();
        int NumeroFactura =f.getNumeroFactura();
        Date Fecha = new Date(2020,12,12);
        String TipoPago =f.getTipoPago();
        int DocumentoCliente =f.getDocumentoCliente();
        String NombreCliente =f.getNombreCliente();
        double Subtotal =f.getSubtotal();
        int Descuento =f.getDescuento();
        int Iva=f.getIva();
        double TotalDescuento=f.getTotalDescuento();
        double TotalImpuesto=f.getTotalImpuesto();
        double Total=f.getTotal();

        String insertSql = "UPDATE Facturas SET ( NumeroFactura, Fecha,TipodePago ,DocumentoCliente ,NombreCliente, Subtotal, Descuento, IVA, TotalDescuento, TotalImpuesto,Total ) VALUES "
                + "( "+ NumeroFactura +", '"+ Fecha +"', '"+ TipoPago +"', "+ DocumentoCliente +", '"+ NombreCliente +"' , "+ Subtotal +", "+ Descuento +", "+ Iva +", "+ TotalDescuento +", "+ TotalImpuesto +", "+ Total +");";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void borrarFactura(int id) throws ClassNotFoundException{
     //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        
        String insertSql = "DELETE FROM Facturas WHERE idFactura=" + id;

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
     
      public void borrarDetalles(int id) throws ClassNotFoundException{
     //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        
        String insertSql = "DELETE FROM Detalles WHERE idFactura=" + id;

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertarDetalle(Detalles d) throws ClassNotFoundException{
     //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                + "database=prueba;"
                + "user=jorge;"
                + "password=12345678;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        
        int idFactura = d.getIdFactura();
        int idProducto = d.getIdProducto();       
        int Cantidad = d.getCantidad();
        double PrecioUnitario= d.getPrecioUnitario();

        String insertSql = "INSERT INTO Detalles ( idFactura, idProducto, Cantidad, PrecioUnitario) VALUES "
                + "( "+ idFactura +", '"+ idProducto +"', '"+ Cantidad +"', "+ PrecioUnitario +");";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
