/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoginDTO;
import DAO.KetNoiCSDL;
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
public class LoginDAO extends KetNoiCSDL{
    public LoginDTO checkLogin(String TenDangNhap, String MatKhau){
        LoginDTO lgdto = null;
        try {
            String sql = "select TenDangNhap, MatKhau, VaiTro from Login where TenDangNhap=? and MatKhau=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, TenDangNhap);
            ps.setString(2, MatKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LoginDTO lg = new LoginDTO();
                lg.setTenDangNhap(TenDangNhap);
                lg.setMatKhau(MatKhau);
                lg.setChucVu(rs.getString("VaiTro"));
                return lg;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
   public boolean insertTK(LoginDTO lgdto){
        String sql = "INSERT INTO Login([TenDangNhap],[MatKhau],[VaiTro]) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lgdto.getTenDangNhap());
            ps.setString(2, lgdto.getMatKhau());
            ps.setString(3, lgdto.getChucVu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   
   public boolean updateTK(LoginDTO lgdto){
        String sql = "UPDATE [dbo].[Login] SET [TenDangNhap] = ?, [MatKhau] = ?, [VaiTro] = ? WHERE [id] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lgdto.getTenDangNhap());
            ps.setString(2, lgdto.getMatKhau());
            ps.setString(3, lgdto.getChucVu());
            ps.setInt(4, lgdto.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteTK(LoginDTO lgdto){
        String sql = "DELETE FROM Login WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, lgdto.getId());
            return ps.executeUpdate() > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
   
   public LoginDTO timTDN(String TenDangNhap){
        String sql = "SELECT * FROM Login WHERE id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, TenDangNhap);
            try(ResultSet rs = ps.executeQuery();){
                if(rs.next()){
                    LoginDTO ncc = new LoginDTO();
                    ncc.setId(rs.getInt("id"));
                    ncc.setTenDangNhap(rs.getString("TenDangNhap"));
                    ncc.setMatKhau(rs.getString("MatKhau"));
                    ncc.setChucVu(rs.getString("VaiTro"));
                    return ncc;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<LoginDTO> timTDNAll(){
        String sql = "SELECT * FROM Login";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try(ResultSet rs = ps.executeQuery();){
                List<LoginDTO> list = new ArrayList<>();
                while(rs.next()){
                    LoginDTO ncc = new LoginDTO();
                    ncc.setId(rs.getInt("id"));
                    ncc.setTenDangNhap(rs.getString("TenDangNhap"));
                    ncc.setMatKhau(rs.getString("MatKhau"));
                    ncc.setChucVu(rs.getString("VaiTro"));
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
