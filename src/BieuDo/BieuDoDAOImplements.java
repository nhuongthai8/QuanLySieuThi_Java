/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BieuDo;

import DAO.KetNoiCSDL;
import DTO.ChiTietHDDTO;
import DAO.ChiTietHDDAO;
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
public class BieuDoDAOImplements implements BieuDoDAO{

    @Override
    public List<ChiTietHDDTO> getListCTHD() {
        String sql ="select NgayNhap, count(ThanhTien) as SoLuong, sum(ThanhTien) as ThanhTien from CTHD group by NgayNhap"; //tính tổng doanh thu trong ngày
        //String sql ="select NgayNhap, count(ThanhTien) as SoLuong, sum(ThanhTien) as ThanhTien from CTHD group by NgayNhap, ThanhTien";
        try{
            List<ChiTietHDDTO> list = new ArrayList<>();
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=MSI\\SQLEXPRESS;database=QuanLySieuThi", "sa", "123456");
            PreparedStatement ps =(PreparedStatement)con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHDDTO doanhthu = new ChiTietHDDTO();
                doanhthu.setNgayNhap(rs.getDate("NgayNhap"));
                doanhthu.setThanhTien(rs.getInt("ThanhTien"));
                list.add(doanhthu);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
