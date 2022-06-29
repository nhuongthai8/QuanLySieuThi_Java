/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhVienDTO;
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
public class NhVienDAO extends KetNoiCSDL {
    SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
    
    public boolean insertNV(NhVienDTO nv){
        String sql = "INSERT INTO [dbo].[NhanVien]([MaNV],[TenNV],[SDT],[DiaChi],[GioiTinh],[NoiSinh],[NgaySinh],[ChucVu],[Email])VALUES(?,?,?,?,?,?,?,?,?)";
        try
        {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nv.getMaNV());
                ps.setString(2, nv.getTenNV());
                ps.setString(3, nv.getSDT());
                ps.setString(4, nv.getDiaChi());
                ps.setInt(5, nv.getGioiTinh());
                ps.setString(6, nv.getNoiSinh());
                ps.setString(7, formatdate.format(nv.getNgaySinh()));
                ps.setString(8, nv.getChucVu());
                ps.setString(9, nv.getEmail());
                return ps.executeUpdate()>0;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteNV(NhVienDTO nv){
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        try
        {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nv.getMaNV());
                return ps.executeUpdate()>0;            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateNV(NhVienDTO nv){
        String sql = "UPDATE [dbo].[NhanVien] SET [TenNV] = ?, [SDT] = ?,[DiaChi] = ?,[GioiTinh] = ?,[NoiSinh] = ?,[NgaySinh] = ?,[ChucVu] = ?,[Email] = ? WHERE MaNV = ?";
        try
        {            
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(9, nv.getMaNV());
                ps.setString(1, nv.getTenNV());
                ps.setString(2, nv.getSDT());
                ps.setString(3, nv.getDiaChi());
                ps.setInt(4, nv.getGioiTinh());
                ps.setString(5, nv.getNoiSinh());
                ps.setString(6, formatdate.format(nv.getNgaySinh()));
                ps.setString(7, nv.getChucVu());
                ps.setString(8, nv.getEmail());
                return ps.executeUpdate()>0;            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public NhVienDTO timNV(String MaNV){
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaNV);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    NhVienDTO kh = new NhVienDTO();
                    kh.setMaNV(rs.getString("MaNV"));
                    kh.setTenNV(rs.getString("TenNV"));
                    kh.setSDT(rs.getString("SDT"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setGioiTinh(rs.getInt("GioiTinh"));
                    kh.setNoiSinh(rs.getString("NoiSinh"));
                    kh.setNgaySinh(rs.getDate("NgaySinh"));
                    kh.setChucVu(rs.getString("ChucVu"));
                    kh.setEmail(rs.getString("Email"));
                    return kh;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<NhVienDTO> timNVAll(){
        String sql = "SELECT * FROM NhanVien";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try(ResultSet rs = ps.executeQuery();){
                List<NhVienDTO> list = new ArrayList<>();
                while(rs.next()){
                    NhVienDTO kh = new NhVienDTO();
                    kh.setMaNV(rs.getString("MaNV"));
                    kh.setTenNV(rs.getString("TenNV"));
                    kh.setSDT(rs.getString("SDT"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setGioiTinh(rs.getInt("GioiTinh"));
                    kh.setNoiSinh(rs.getString("NoiSinh"));
                    kh.setNgaySinh(rs.getDate("NgaySinh"));
                    kh.setChucVu(rs.getString("ChucVu"));
                    kh.setEmail(rs.getString("Email"));
                    list.add(kh);
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
