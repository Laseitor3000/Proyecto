/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.sql.*;

/**
 *
 * @author nico
 */
public class Base {

    Connection c = null;
    Statement stmt = null;

    public Base() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:basesita.db");
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS EMPLEADOS "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " CODIGO INTEGER NOT NULL, "
                    + " NOMBRE TEXT NOT NULL, "
                    + " APELLIDO TEXT NOT NULL, "
                    + " EDAD TEXT NOT NULL,"
                    + " EMAIL TEXT NOT NULL, "
                    + " DIRECCION TEXT NOT NULL, "
                    + " SALARIO TEXT NOT NULL)";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public boolean Guardar(String nombre, String apellido, String edad, String email, String direccion, String salario) {
        boolean ret=false;
        try {
            stmt.execute("INSERT INTO empleados (CODIGO,NOMBRE,APELLIDO,EDAD,EMAIL,DIRECCION,SALARIO) VALUES(123, '"+nombre+"', '"+apellido+"', '"+edad+"', '"+email+"', '"+direccion+"', '"+salario+"')");
                    ret=true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            ret=false;
        }return ret;
    }
}
