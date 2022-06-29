/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhCCDTO;
import DAO.KetNoiCSDL;
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
public class NhCCDAO extends KetNoiCSDL {

    public boolean insertNCC(NhCCDTO ncc){
        String sql = "INSERT INTO [dbo].[NhaCungCap]([MaNCC],[TenNCC],[SDT],[DiaChi],[Email]) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getSDT());
            ps.setString(4, ncc.getDiaChi());
            ps.setString(5, ncc.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNCC(NhCCDTO ncc){
        String sql = "UPDATE [dbo].[NhaCungCap] SET [TenNCC] = ?, [SDT] = ?, [DiaChi] = ?, [Email] = ? WHERE [MaNCC] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getSDT());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getEmail());
            ps.setString(5, ncc.getMaNCC());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNCC(NhCCDTO ncc){
        String sql = "DELETE FROM NhaCungCap WHERE MaNCC = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getMaNCC());
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public NhCCDTO timNCC(String MaNCC){
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaNCC);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    NhCCDTO ncc = new NhCCDTO();
                    ncc.setMaNCC(rs.getString("MaNCC"));
                    ncc.setTenNCC(rs.getString("TenNCC"));
                    ncc.setSDT(rs.getString("SDT"));
                    ncc.setDiaChi(rs.getString("DiaChi"));
                    ncc.setEmail(rs.getString("Email"));
                    return ncc;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<NhCCDTO> timNCCAll(){
        String sql = "SELECT * FROM NhaCungCap";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try(ResultSet rs = ps.executeQuery();){
                List<NhCCDTO> list = new ArrayList<>();
                while(rs.next()){
                    NhCCDTO ncc = new NhCCDTO();
                    ncc.setMaNCC(rs.getString("MaNCC"));
                    ncc.setTenNCC(rs.getString("TenNCC"));
                    ncc.setSDT(rs.getString("SDT"));
                    ncc.setDiaChi(rs.getString("DiaChi"));
                    ncc.setEmail(rs.getString("Email"));
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

    
}
