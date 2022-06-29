/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HDonDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HDonDAO extends KetNoiCSDL{
    
    public boolean insertHD(HDonDTO hd){
        String sql = "INSERT INTO [dbo].[HoaDon]([MaHD],[MaNV],[MaKH])VALUES (?,?,?)";
        try
        {            
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, hd.getMaHD());
                ps.setString(2, hd.getMaNV());
                ps.setString(3, hd.getMaKH());
                return ps.executeUpdate()>0;            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateHD(HDonDTO hd){
        String sql = "UPDATE [dbo].[HoaDon] SET [MaNV] = ?, [MaKH] = ? WHERE [MaHD] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(3, hd.getMaHD());
            ps.setString(1, hd.getMaNV());
            ps.setString(2, hd.getMaKH());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteHD(HDonDTO hd){
        String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public HDonDTO timHD(String MaHD){
        String sql = "SELECT * FROM HoaDon WHERE MaHD = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaHD);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    HDonDTO hd = new HDonDTO();
                    hd.setMaHD(rs.getString("MaHD"));
                    hd.setMaNV(rs.getString("MaNV"));
                    hd.setMaKH(rs.getString("MaKH"));
                    return hd;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<HDonDTO> timHDAll(){
        String sql = "SELECT * FROM HoaDon";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try(ResultSet rs = ps.executeQuery();){
                List<HDonDTO> list = new ArrayList<>();
                while(rs.next()){
                    HDonDTO hd = new HDonDTO();
                    hd.setMaHD(rs.getString("MaHD"));
                    hd.setMaNV(rs.getString("MaNV"));
                    hd.setMaKH(rs.getString("MaKH"));
                    list.add(hd);
                }
                return list;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
