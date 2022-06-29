/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHgDTO;
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
public class KhachHgDAO extends KetNoiCSDL {

    SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
    public boolean insertKH(KhachHgDTO kh){
        String sql = "INSERT INTO [dbo].[KhachHang]([MaKH],[TenKH],[SDT],[DiaChi],[GioiTinh],[NoiSinh],[NgaySinh],[Email])VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getSDT());
            ps.setString(4, kh.getDiaChi());
            ps.setInt(5, kh.getGioiTinh());
            ps.setString(6, kh.getNoiSinh());
            ps.setString(7, formatdate.format(kh.getNgaySinh()));
            ps.setString(8, kh.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteKH(KhachHgDTO kh){
        String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateKH(KhachHgDTO kh){
        String sql = "UPDATE [dbo].[KhachHang]SET [TenKH] = ?,[SDT] = ?,[DiaChi] = ?,[GioiTinh] = ?,[NoiSinh] = ?,[NgaySinh] = ?,[Email] = ? WHERE [MaKH] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(8, kh.getMaKH());
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getSDT());
            ps.setString(3, kh.getDiaChi());
            ps.setInt(4, kh.getGioiTinh());
            ps.setString(5, kh.getNoiSinh());
            ps.setString(6, formatdate.format(kh.getNgaySinh()));
            ps.setString(7, kh.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public KhachHgDTO timKH(String MaKH){
        String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaKH);
            try ( ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    KhachHgDTO kh = new KhachHgDTO();
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setTenKH(rs.getString("TenKH"));
                    kh.setSDT(rs.getString("SDT"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setGioiTinh(rs.getInt("GioiTinh"));
                    kh.setNoiSinh(rs.getString("NoiSinh"));
                    kh.setNgaySinh(rs.getDate("NgaySinh"));
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

    public List<KhachHgDTO> timKHAll(){
        String sql = "SELECT * FROM KhachHang";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try ( ResultSet rs = ps.executeQuery();) {
                List<KhachHgDTO> list = new ArrayList<>();
                while (rs.next()) {
                    KhachHgDTO kh = new KhachHgDTO();
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setTenKH(rs.getString("TenKH"));
                    kh.setSDT(rs.getString("SDT"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    kh.setGioiTinh(rs.getInt("GioiTinh"));
                    kh.setNoiSinh(rs.getString("NoiSinh"));
                    kh.setNgaySinh(rs.getDate("NgaySinh"));
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
