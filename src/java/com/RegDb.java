/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import DAO.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author acer
 */
public class RegDb {

    DbConnector dc = new DbConnector();
    Connection con;

    public RegDb() {
        con = dc.getConnection();
    }

    public boolean RegisterUser(RegisterBo bo) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into registrationdb values (?,?,?,?,?)");
             PreparedStatement ps1 = con.prepareStatement("insert into logindb values (?,?)");
            ps.setString(1, bo.getFirstname());
            ps.setString(2, bo.getLastname());
            ps.setString(3, bo.getEmail());
            ps.setString(4, bo.getPhone());
            if (bo.getPass().equals(bo.getRepass())) {
                ps.setString(5, bo.getPass());
                ps1.setString(1, bo.getEmail());
                ps1.setString(2, bo.getPass());
                
                ps.execute();
                ps1.execute();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
