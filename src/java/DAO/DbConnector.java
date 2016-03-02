/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vspace
 */
public class DbConnector {
    public Connection getConnection() {
        Connection con = null;

        String dbname = "cloudclient";
        String dburl = "Localhost";
        String dbusername = "root";
        String dbpassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           
            con = DriverManager.getConnection("jdbc:mysql://" + dburl + "/" + dbname, dbusername, dbpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
