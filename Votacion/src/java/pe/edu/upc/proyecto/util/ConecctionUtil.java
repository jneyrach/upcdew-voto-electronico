/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.proyecto.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Hamilton
 */
public class ConecctionUtil {

    private static final String URL =
   /**         "jdbc:mysql://localhost/basenotas,root,admin";  */
             "jdbc:mysql://localhost:3306/db_voto?user=root&password=";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
