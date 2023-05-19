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
    
    public void intertarFactura(Facturas f) throws ClassNotFoundException{
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

        String insertSql = "INSERT INTO Facturas ( idFactura, NumeroFactura, Fecha,TipodePago ,DocumentoCliente ,NombreCliente, Subtotal, Descuento, IVA, TotalDescuento, TotalImpuesto,Total ) VALUES "
                + "( "+ idFactura +","+ NumeroFactura +", '"+ Fecha +"', '"+ TipoPago +"', "+ DocumentoCliente +", '"+ NombreCliente +"' , "+ Subtotal +", "+ Descuento +", "+ Iva +", "+ TotalDescuento +", "+ TotalImpuesto +", "+ Total +");";

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
