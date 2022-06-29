/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SPhamDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */


public class SPhamDAO extends KetNoiCSDL{
    SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
    
    public boolean insertSP(SPhamDTO sp){
        String sql = "INSERT INTO [dbo].[SanPham]([MaSP],[TenSP],[GiaTien],[SoLuong],[HSD],[MaLoai],[MaNCC], [NgayNhap])VALUES(?,?,?,?,?,?,?,?)";
        try
        {            
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, sp.getMaSP());
                ps.setString(2, sp.getTenSP());
                ps.setFloat(3, sp.getGiaTien());
                ps.setInt(4, sp.getSoLuong());
                ps.setString(5, sp.getHSD());
                ps.setString(6, sp.getMaLoai());//
                ps.setString(7, sp.getMaNCC());//
                ps.setString(8, formatdate.format(sp.getDate()));
                return ps.executeUpdate()>0;            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteSP(SPhamDTO sp){
        String sql = "DELETE FROM SanPham WHERE MaSP = ?";
        try
        {            
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, sp.getMaSP());
                return ps.executeUpdate()>0;           
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateSP(SPhamDTO sp){
        String sql = "UPDATE [dbo].[SanPham] SET [TenSP] = ?,[GiaTien] = ?,[SoLuong] = ?,[HSD] = ?,[MaLoai] = ?,[MaNCC] = ?, [NgayNhap] = ? WHERE [MaSP] = ?";
        try
        {            
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(8, sp.getMaSP());
                ps.setString(1, sp.getTenSP());
                ps.setFloat(2, sp.getGiaTien());
                ps.setInt(3, sp.getSoLuong());
                ps.setString(4, sp.getHSD());
                ps.setString(5, sp.getMaLoai());
                ps.setString(6, sp.getMaNCC());
                ps.setString(7, formatdate.format(sp.getDate()));
                return ps.executeUpdate()>0;            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
        
    public SPhamDTO timSP(String MaSP){
        String sql = "SELECT * FROM SanPham WHERE MaSP = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaSP);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    SPhamDTO sp = new SPhamDTO();
                    sp.setMaSP(rs.getString("MaSP"));
                    sp.setTenSP(rs.getString("TenSP"));
                    sp.setGiaTien(rs.getFloat("GiaTien"));
                    sp.setSoLuong(rs.getInt("SoLuong"));
                    sp.setHSD(rs.getString("HSD"));
                    sp.setMaLoai(rs.getString("MaLoai"));
                    sp.setMaNCC(rs.getString("MaNCC"));
                    sp.setDate(rs.getDate("NgayNhap"));
                    return sp;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<SPhamDTO> timSPAll(){
        String sql = "SELECT * FROM SanPham";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try(ResultSet rs = ps.executeQuery();){
                List<SPhamDTO> list = new ArrayList<>();
                while(rs.next()){
                    SPhamDTO sp = new SPhamDTO();
                    sp.setMaSP(rs.getString("MaSP"));
                    sp.setTenSP(rs.getString("TenSP"));
                    sp.setGiaTien(rs.getFloat("GiaTien"));
                    sp.setSoLuong(rs.getInt("SoLuong"));
                    sp.setHSD(rs.getString("HSD"));
                    sp.setMaLoai(rs.getString("MaLoai"));
                    sp.setMaNCC(rs.getString("MaNCC"));
                    sp.setDate(rs.getDate("NgayNhap"));
                    list.add(sp);
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
