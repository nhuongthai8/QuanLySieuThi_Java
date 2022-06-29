/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class KetNoiCSDL {
    protected Connection con = null;
    public KetNoiCSDL(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionurl = "jdbc:sqlserver://localhost:1433;instance=DESKTOP-QEN4LJI\\SQLEXPRESS;database=QuanLySieuThi";
            con = DriverManager.getConnection(connectionurl,"sa","123456");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
       
}
