/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoaiSPDTO;
import DAO.KetNoiCSDL;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LoaiSPDAO extends KetNoiCSDL{
    public boolean insertLSP(LoaiSPDTO lsp){
        String sql = "INSERT INTO [dbo].[LoaiSP]([MaLoai],[TenLoai]) VALUES (?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lsp.getMaLoai());
            ps.setString(2, lsp.getTenLoai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateLSP(LoaiSPDTO lsp){
        String sql = "UPDATE [dbo].[LoaiSP] SET [TenLoai] = ? WHERE [MaLoai] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lsp.getTenLoai());
            ps.setString(2, lsp.getMaLoai());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteLSP(LoaiSPDTO lsp){
        String sql = "DELETE FROM LoaiSP WHERE MaLoai = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lsp.getMaLoai());
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public LoaiSPDTO timLSP(String MaLoai){
        String sql = "SELECT * FROM LoaiSP WHERE MaLoai = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaLoai);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    LoaiSPDTO ncc = new LoaiSPDTO();
                    ncc.setMaLoai(rs.getString("MaLoai"));
                    ncc.setTenLoai(rs.getString("TenLoai"));
                    return ncc;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<LoaiSPDTO> timLSPAll(){
        String sql = "SELECT * FROM LoaiSP";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try(ResultSet rs = ps.executeQuery();){
                List<LoaiSPDTO> list = new ArrayList<>();
                while(rs.next()){
                    LoaiSPDTO ncc = new LoaiSPDTO();
                    ncc.setMaLoai(rs.getString("MaLoai"));
                    ncc.setTenLoai(rs.getString("TenLoai"));
                    list.add(ncc);
                }
                return list;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public List<LoaiSPDTO> getALLLSP(){
        List<LoaiSPDTO> lspdto = new ArrayList<>();
        String sql = "Select * from LoaiSP";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LoaiSPDTO lsp = new LoaiSPDTO();
                lsp.setMaLoai(rs.getString(1));
                lsp.setTenLoai(rs.getString(2));
                lspdto.add(lsp);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.print("Error: "+e.toString());
        }
        return lspdto;
    }
    
}
