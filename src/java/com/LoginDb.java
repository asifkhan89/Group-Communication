/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import DAO.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class LoginDb {
    DbConnector dc=new DbConnector();
    Connection con;
    public LoginDb() {
    con=dc.getConnection();
    }
    
    public boolean LoginDB(LoginBo bo){
        try{
           String user= bo.getEmail();
            String pass=bo.getPass();
            PreparedStatement ps=con.prepareStatement("select * from logindb where email='"+user+"' && password='"+pass+"'");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {                
                return true;
            }else{
                return false; 
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
        
        
    }
    
}
