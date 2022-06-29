/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietHDDTO;
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
public class ChiTietHDDAO extends KetNoiCSDL{
    
    SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
    
    public boolean insertCTHD(ChiTietHDDTO cthd){        
        String sql = "INSERT INTO [dbo].[CTHD]([MaCTHD],[MaHD],[MaSP],[SoLuong],[GiaTien],[ThanhTien], [NgayNhap])VALUES (?,?,?,?,?,?,?)";
        try
        {            
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, cthd.getMaCTHD());
                ps.setString(2, cthd.getMaHD());
                ps.setString(3, cthd.getMaSP());
                ps.setInt(4, cthd.getSoLuong());
                ps.setFloat(5, cthd.getGiaTien());
                ps.setInt(6, cthd.getThanhTien());
                ps.setString(7, formatdate.format(cthd.getNgayNhap()));
                return ps.executeUpdate()>0;            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateCTHD(ChiTietHDDTO cthd){
        String sql = "UPDATE [dbo].[CTHD] SET [MaHD] = ?, [MaSP] = ?, [SoLuong] = ?, [GiaTien] = ?, [ThanhTien] = ?, [NgayNhap] = ? WHERE [MaCTHD] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(7, cthd.getMaCTHD());
                ps.setString(1, cthd.getMaHD());
                ps.setString(2, cthd.getMaSP());
                ps.setInt(3, cthd.getSoLuong());
                ps.setFloat(4, cthd.getGiaTien());
                ps.setInt(5, cthd.getThanhTien());
                ps.setString(6, formatdate.format(cthd.getNgayNhap()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteCTHD(ChiTietHDDTO cthd){
        String sql = "DELETE FROM CTHD WHERE MaCTHD = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cthd.getMaCTHD());
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean thanhtoanCTHD(ChiTietHDDTO cthd){
        String sql = "SELECT SUM (CTHD.SoLuong*CTHD.GiaTien) AS ThanhTien FROM CTHD, SanPham WHERE MaHD = ? and CTHD.MaSP = SanPham.MaSP ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cthd.getMaHD());
            return ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public ChiTietHDDTO timCTHD(String MaCTHD){
        String sql = "SELECT * FROM CTHD WHERE MaCTHD = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaCTHD);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    ChiTietHDDTO cthd = new ChiTietHDDTO();
                    cthd.setMaCTHD(rs.getString("MaCTHD"));
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setMaSP(rs.getString("MaSP"));        
                    cthd.setSoLuong(rs.getInt("SoLuong"));
                    cthd.setGiaTien(rs.getFloat("GiaTien"));
                    cthd.setThanhTien(rs.getInt("ThanhTien"));
                    cthd.setNgayNhap(rs.getDate("NgayNhap"));
                    return cthd;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<ChiTietHDDTO> timDateCTHD(String Date){
        List<ChiTietHDDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM CTHD WHERE NgayNhap like ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%"+Date+"");
            ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ChiTietHDDTO cthd = new ChiTietHDDTO();
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setThanhTien(rs.getInt("ThanhTien"));
                    cthd.setNgayNhap(rs.getDate("NgayNhap"));
                    list.add(cthd);
                }
                return list;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<ChiTietHDDTO> timMaCTHD(String MaHD){
        List<ChiTietHDDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM CTHD WHERE MaHD = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaHD);
            ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ChiTietHDDTO cthd = new ChiTietHDDTO();
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setThanhTien(rs.getInt("ThanhTien"));
                    cthd.setNgayNhap(rs.getDate("NgayNhap"));
                    list.add(cthd);
                }
                return list;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<ChiTietHDDTO> timCTHDAll(){
        String sql = "SELECT * FROM CTHD";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try(ResultSet rs = ps.executeQuery();){
                List<ChiTietHDDTO> list = new ArrayList<>();
                while(rs.next()){
                    ChiTietHDDTO cthd = new ChiTietHDDTO();
                    cthd.setMaCTHD(rs.getString("MaCTHD"));
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setMaSP(rs.getString("MaSP"));        
                    cthd.setSoLuong(rs.getInt("SoLuong"));
                    cthd.setGiaTien(rs.getFloat("GiaTien"));
                    cthd.setThanhTien(rs.getInt("ThanhTien"));
                    cthd.setNgayNhap(rs.getDate("NgayNhap"));
                    list.add(cthd);
                }
                return list;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    //biểu đồ
//    public List<ChiTietHDDTO> getlistDoanhThu() {
//        String sql ="select ThanhTien, NgayNhap from CTHD";
//        List<ChiTietHDDTO> list = new ArrayList<>();
//        try {
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=MSI\\SQLEXPRESS;database=QuanLySieuThi", "sa", "123456");
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                ChiTietHDDTO doanhthu = new ChiTietHDDTO();
//                doanhthu.setNgayNhap(rs.getDate("NgayNhap"));
//                doanhthu.setThanhTien(rs.getInt("ThanhTien"));
//                list.add(doanhthu);
//            }
//            con.close();
//            ps.close();
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

}
