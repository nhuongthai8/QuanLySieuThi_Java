/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import DAO.ChiTietHDDAO;
import DAO.HDonDAO;
import DTO.ChiTietHDDTO;
import DTO.HDonDTO;
import Misc.MiscData;
import Misc.MiscDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class HoaDon extends javax.swing.JFrame {

    SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
    /**
     * Creates new form HoaDon
     */
    public HoaDon() {
        initComponents();
        initComboboxMHD();
        initComboboxMSP();
        initComboboxMaNV();
        initComboboxMaKH();
        showTableCTHD();
        showTableHD();
        showDatabaseCTHD();
        showDatabaseHD();
    }

    
    private void initComboboxMHD() {
        String sql = "Select MaHD from HoaDon";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=MSI\\SQLEXPRESS;database=QuanLySieuThi","sa","123456");
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            MHDcb.removeAllItems();
            while(rs.next()){
                MHDcb.addItem(rs.getString("MaHD"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            MiscDialog.showErrorDialog(null, ex.getMessage(), "Lỗi");
        }
    }
    
    private void initComboboxMSP() {
        String sql = "Select MaSP from SanPham";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=MSI\\SQLEXPRESS;database=QuanLySieuThi","sa","123456");
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            MSPcb.removeAllItems();
            while(rs.next()){
                MSPcb.addItem(rs.getString("MaSP"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            MiscDialog.showErrorDialog(null, ex.getMessage(), "Lỗi");
        }
    }
    
    private void initComboboxMaNV() {
        String sql = "Select MaNV from NhanVien";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=MSI\\SQLEXPRESS;database=QuanLySieuThi","sa","123456");
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            Manvcb.removeAllItems();
            while(rs.next()){
                Manvcb.addItem(rs.getString("MaNV"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            MiscDialog.showErrorDialog(null, ex.getMessage(), "Lỗi");
        }
    }
    
    private void initComboboxMaKH() {
        String sql = "Select MaKH from KhachHang";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=MSI\\SQLEXPRESS;database=QuanLySieuThi","sa","123456");
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            Makhcb.removeAllItems();
            while(rs.next()){
                Makhcb.addItem(rs.getString("MaKH"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            MiscDialog.showErrorDialog(null, ex.getMessage(), "Lỗi");
        }
    }
    
    private DefaultTableModel model;
    private DefaultTableModel model2;
    
    private void refresh(){
        Macthdtxt.setText("");
        Thanhtientxt.setText("");
        Giatientxt.setText("");
        Soluongtxt.setText("");
    }
    
    private void showTableCTHD(){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"MÃ CTHD","MÃ HÓA ĐƠN","MÃ SẢN PHẨM","SỐ LƯỢNG","GIÁ TIỀN","THÀNH TIỀN","NGÀY NHẬP"});
        jTable2.setModel(model);
    }
    
    private void showTableHD(){
        model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(new String[]{"MÃ HÓA ĐƠN","MÃ NHÂN VIÊN","MÃ KHÁCH HÀNG"});
        jTable1.setModel(model2);
    }
    
    //int ThanhTien =0;
    
    private void showDatabaseCTHD(){
        try{
            ChiTietHDDAO dao = new ChiTietHDDAO();
            List<ChiTietHDDTO> list = dao.timCTHDAll();
            model.setRowCount(0);
            for(ChiTietHDDTO it : list){
                model.addRow(new Object[]{
                    it.getMaCTHD(),it.getMaHD(),it.getMaSP(),it.getSoLuong(),it.getGiaTien(),it.getThanhTien(),it.getNgayNhap()
                });
                //ThanhTien = it.getThanhTien();
            }
            //Thanhtientxt.setText(ThanhTien+"");
            model.fireTableDataChanged();
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }
    
    private void showDatabaseHD(){
        try{
            HDonDAO dao = new HDonDAO();
            List<HDonDTO> list = dao.timHDAll();
            model2.setRowCount(0);
            for(HDonDTO it : list){
                model2.addRow(new Object[]{
                    it.getMaHD(),it.getMaNV(),it.getMaKH()
                });
            }
            model2.fireTableDataChanged();
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Soluongtxt = new javax.swing.JTextField();
        Giatientxt = new javax.swing.JTextField();
        Thanhtientxt = new javax.swing.JTextField();
        Macthdtxt = new javax.swing.JTextField();
        MHDcb = new javax.swing.JComboBox<>();
        MSPcb = new javax.swing.JComboBox<>();
        Thembtn = new javax.swing.JButton();
        Huybtn = new javax.swing.JButton();
        Suabtn = new javax.swing.JButton();
        Xoabtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Mahdtxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Manvcb = new javax.swing.JComboBox<>();
        Makhcb = new javax.swing.JComboBox<>();
        Themhdbtn = new javax.swing.JButton();
        Suahdbtn = new javax.swing.JButton();
        Xoahdbtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Ngaynhaptxt = new javax.swing.JTextField();
        Thanhtoanbtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi Tiết Hóa Đơn & Hóa Đơn");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 548, 936, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 6, -1, -1));

        Backbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_back_to_20px.png"))); // NOI18N
        Backbtn.setText("Trở về");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 116, -1, 43));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã CTHD:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã hóa đơn:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 380, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Số lượng:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giá tiền:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 420, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Thành tiền:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mã sản phẩm:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 380, -1, -1));
        getContentPane().add(Soluongtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 420, 186, -1));
        getContentPane().add(Giatientxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 420, 178, -1));
        getContentPane().add(Thanhtientxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 173, -1));
        getContentPane().add(Macthdtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 380, 186, -1));

        MHDcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(MHDcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 380, 169, -1));

        MSPcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(MSPcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(762, 380, 140, -1));

        Thembtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thembtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_plus_+_20px.png"))); // NOI18N
        Thembtn.setText("Thêm");
        Thembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThembtnActionPerformed(evt);
            }
        });
        getContentPane().add(Thembtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 470, -1, 45));

        Huybtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Huybtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_new_copy_20px.png"))); // NOI18N
        Huybtn.setText("Làm Mới");
        Huybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuybtnActionPerformed(evt);
            }
        });
        getContentPane().add(Huybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(815, 470, -1, 45));

        Suabtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Suabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_change_20px_1.png"))); // NOI18N
        Suabtn.setText("Sửa");
        Suabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuabtnActionPerformed(evt);
            }
        });
        getContentPane().add(Suabtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 470, -1, 45));

        Xoabtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Xoabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_minus_20px.png"))); // NOI18N
        Xoabtn.setText("Xóa");
        Xoabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoabtnActionPerformed(evt);
            }
        });
        getContentPane().add(Xoabtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 470, -1, 45));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 166, 936, 149));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("CHI TIẾT HÓA ĐƠN");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Mã hóa đơn:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, -1, -1));
        getContentPane().add(Mahdtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 60, 160, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Mã nhân viên:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 60, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Mã khách hàng:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 60, -1, -1));

        Manvcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Manvcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 60, 160, -1));

        Makhcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(Makhcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 160, -1));

        Themhdbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Themhdbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_plus_+_20px.png"))); // NOI18N
        Themhdbtn.setText("Thêm");
        Themhdbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemhdbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Themhdbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 115, -1, 45));

        Suahdbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Suahdbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_change_20px_1.png"))); // NOI18N
        Suahdbtn.setText("Sửa");
        Suahdbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuahdbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Suahdbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 115, -1, 45));

        Xoahdbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Xoahdbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_minus_20px.png"))); // NOI18N
        Xoahdbtn.setText("Xóa");
        Xoahdbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoahdbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Xoahdbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 115, -1, 45));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Ngày nhập:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 420, -1, -1));
        getContentPane().add(Ngaynhaptxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 420, 145, -1));

        Thanhtoanbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thanhtoanbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_reserve_20px_2.png"))); // NOI18N
        Thanhtoanbtn.setText("Thanh Toán");
        Thanhtoanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhtoanbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Thanhtoanbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 470, -1, 45));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HoaDon Background.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try{
            int row = jTable2.getSelectedRow();
            if(row >=0){
                String id = (String)jTable2.getValueAt(row, 0);
                ChiTietHDDAO dao = new ChiTietHDDAO();
                ChiTietHDDTO sp = dao.timCTHD(id);
                if(sp != null){
                    Macthdtxt.setText(sp.getMaCTHD());
                    MHDcb.setSelectedItem(sp.getMaHD());
                    MSPcb.setSelectedItem(sp.getMaSP());
                    Soluongtxt.setText(String.valueOf(sp.getSoLuong()));
                    Giatientxt.setText(String.valueOf(sp.getGiaTien()));
                    Thanhtientxt.setText(String.valueOf(sp.getThanhTien()));
                    Ngaynhaptxt.setText(formatdate.format(sp.getNgayNhap()));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        setVisible(false);
        TrangChu form = new TrangChu();
        form.setVisible(true);
    }//GEN-LAST:event_BackbtnActionPerformed

    private void ThembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThembtnActionPerformed
        StringBuilder sb = new StringBuilder();
        MiscData.DataEmty(Macthdtxt, sb, "Vui lòng nhập Mã CTHD");
        MiscData.DataEmty(Giatientxt, sb, "Vui lòng nhập Giá tiền");
        MiscData.DataEmty(Soluongtxt, sb, "Vui lòng nhập Số lượng");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        try{
            ChiTietHDDTO cthd = new ChiTietHDDTO();
            cthd.setMaCTHD(Macthdtxt.getText());
            cthd.setGiaTien(Float.parseFloat(Giatientxt.getText()));
            //cthd.setThanhTien(Integer.parseInt(Thanhtientxt.getText()));
            cthd.setSoLuong(Integer.parseInt(Soluongtxt.getText()));
            cthd.setMaHD(MHDcb.getSelectedItem().toString());
            cthd.setMaSP(MSPcb.getSelectedItem().toString());
            cthd.setNgayNhap(formatdate.parse(Ngaynhaptxt.getText()));

            ChiTietHDDAO dao = new ChiTietHDDAO();
            if(dao.insertCTHD(cthd)){
                MiscDialog.showMessageDialog(null, "Thêm Chi tiết hóa đơn thành công", "Thông báo");
                showDatabaseCTHD();
                refresh();
            }
            else{
                MiscDialog.showErrorDialog(null, "Thêm không thành công", "Lỗi");
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
        }
    }//GEN-LAST:event_ThembtnActionPerformed

    private void HuybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuybtnActionPerformed
        Macthdtxt.setText("");
        Soluongtxt.setText("");
        Giatientxt.setText("");
        Thanhtientxt.setText("");
    }//GEN-LAST:event_HuybtnActionPerformed

    private void SuabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuabtnActionPerformed
        StringBuilder sb = new StringBuilder();
        MiscData.DataEmty(Macthdtxt, sb, "Vui lòng nhập Mã CTHD");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        if(MiscDialog.showConfirmDialog(null, "Bạn có muốn cập nhật lại không?", "Thông báo") == JOptionPane.NO_OPTION){
            return;
        }
        try{
            ChiTietHDDTO cthd = new ChiTietHDDTO();
            cthd.setMaCTHD(Macthdtxt.getText());
            cthd.setGiaTien(Float.parseFloat(Giatientxt.getText()));
            cthd.setThanhTien(Integer.parseInt(Thanhtientxt.getText()));
            cthd.setSoLuong(Integer.parseInt(Soluongtxt.getText()));
            cthd.setMaHD(MHDcb.getSelectedItem().toString());
            cthd.setMaSP(MSPcb.getSelectedItem().toString());
            cthd.setNgayNhap(formatdate.parse(Ngaynhaptxt.getText()));

            ChiTietHDDAO cthddao = new ChiTietHDDAO();
            if(cthddao.updateCTHD(cthd)){
                MiscDialog.showMessageDialog(null, "Chỉnh sửa thành công", "Thông báo");
                showDatabaseCTHD();
                refresh();
            }else{
                MiscDialog.showErrorDialog(null, "Chỉnh sửa không thành công", "Lỗi");
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_SuabtnActionPerformed

    private void XoabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoabtnActionPerformed
        StringBuilder sb = new StringBuilder();
        MiscData.DataEmty(Macthdtxt, sb, "Vui lòng nhập Mã CTHD");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        if(MiscDialog.showConfirmDialog(null, "Bạn có muốn xóa CTHD này không?", "Thông báo") == JOptionPane.NO_OPTION){
            return;
        }
        try{
            ChiTietHDDTO cthd = new ChiTietHDDTO();
            cthd.setMaCTHD(Macthdtxt.getText());
            ChiTietHDDAO cthddao = new ChiTietHDDAO();
            if(cthddao.deleteCTHD(cthd)){
                MiscDialog.showMessageDialog(null, "Xóa thành công", "Thông báo");
                showDatabaseCTHD();
                refresh();
            }else{
                MiscDialog.showErrorDialog(null, "Xóa không thành công", "Lỗi");
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_XoabtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            int row = jTable1.getSelectedRow();
            if(row >=0){
                String id = (String)jTable1.getValueAt(row, 0);
                HDonDAO dao = new HDonDAO();
                HDonDTO sp = dao.timHD(id);
                if(sp != null){
                    Mahdtxt.setText(sp.getMaHD());
                    Manvcb.setSelectedItem(sp.getMaNV());
                    Makhcb.setSelectedItem(sp.getMaKH());;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void ThemhdbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemhdbtnActionPerformed
        StringBuilder sb = new StringBuilder();
        MiscData.DataEmty(Mahdtxt, sb, "Vui lòng nhập Mã hóa đơn");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        try{
            HDonDTO hd = new HDonDTO();
            hd.setMaHD(Mahdtxt.getText());
            hd.setMaNV(Manvcb.getSelectedItem().toString());
            hd.setMaKH(Makhcb.getSelectedItem().toString());

            HDonDAO dao = new HDonDAO();
            if(dao.insertHD(hd)){
                MiscDialog.showMessageDialog(null, "Thêm Hóa đơn thành công", "Thông báo");
                showDatabaseHD();
                refresh();
            }
            else{
                MiscDialog.showErrorDialog(null, "Thêm không thành công", "Lỗi");
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
        }
    }//GEN-LAST:event_ThemhdbtnActionPerformed

    private void SuahdbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuahdbtnActionPerformed
        StringBuilder sb = new StringBuilder();
        MiscData.DataEmty(Mahdtxt, sb, "Vui lòng nhập Mã hóa đơn");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        if(MiscDialog.showConfirmDialog(null, "Bạn có muốn cập nhật lại không?", "Thông báo") == JOptionPane.NO_OPTION){
            return;
        }
        try{
            HDonDTO hd = new HDonDTO();
            hd.setMaHD(Mahdtxt.getText());
            hd.setMaNV(Manvcb.getSelectedItem().toString());
            hd.setMaKH(Makhcb.getSelectedItem().toString());

            HDonDAO dao = new HDonDAO();
            if(dao.updateHD(hd)){
                MiscDialog.showMessageDialog(null, "Chỉnh sửa thành công", "Thông báo");
                showDatabaseHD();
                refresh();
            }else{
                MiscDialog.showErrorDialog(null, "Chỉnh sửa không thành công", "Lỗi");
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_SuahdbtnActionPerformed

    private void XoahdbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoahdbtnActionPerformed
        StringBuilder sb = new StringBuilder();
        MiscData.DataEmty(Mahdtxt, sb, "Vui lòng nhập Mã hóa đơn");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        if(MiscDialog.showConfirmDialog(null, "Bạn có muốn xóa Hóa đơn này không?", "Thông báo") == JOptionPane.NO_OPTION){
            return;
        }
        try{
            HDonDTO hd = new HDonDTO();
            hd.setMaHD(Mahdtxt.getText());
            HDonDAO dao = new HDonDAO();
            if(dao.deleteHD(hd)){
                MiscDialog.showMessageDialog(null, "Xóa thành công", "Thông báo");
                showDatabaseHD();
                refresh();
            }else{
                MiscDialog.showErrorDialog(null, "Xóa không thành công", "Lỗi");
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_XoahdbtnActionPerformed

    private void ThanhtoanbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThanhtoanbtnActionPerformed
        //        StringBuilder sb = new StringBuilder();
        //        try{
            //            ChiTietHDDTO cthd = new ChiTietHDDTO();
            //            cthd.setMaHD(MHDcb.getSelectedItem().toString());
            //
            //            ChiTietHDDAO dao = new ChiTietHDDAO();
            //            if(dao.thanhtoanCTHD(cthd)){
                //                MiscDialog.showMessageDialog(null, "Thanh toán thành công", "Thông báo");
                //                Thanhtientxt.setText(String.valueOf(cthd.getThanhTien()));
                //            }
            //            else{
                //                MiscDialog.showErrorDialog(null, "Thanh toán không thành công", "Thông báo");
                //            }
            //        }catch(Exception e){
            //            e.printStackTrace();
            //            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            //        }

        if (MHDcb.getSelectedItem() == null) {
            MiscDialog.showErrorDialog(null, "Chưa chọn Mã hóa đơn", "Thông báo");
            return;
        }
        ThanhTien();
    }//GEN-LAST:event_ThanhtoanbtnActionPerformed

    
    
    private void ThanhTien(){
        String sql = "SELECT SUM (CTHD.SoLuong*CTHD.GiaTien) AS ThanhTien FROM CTHD, SanPham WHERE MaHD = ? and CTHD.MaSP = SanPham.MaSP";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance=MSI\\SQLEXPRESS;database=QuanLySieuThi","sa","123456");
            PreparedStatement ps = conn.prepareStatement(sql)) {            
            ps.setString(1, (String) MHDcb.getSelectedItem());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Thanhtientxt.setText(rs.getString("ThanhTien"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi tính tiền!");
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDon().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JTextField Giatientxt;
    private javax.swing.JButton Huybtn;
    private javax.swing.JComboBox<String> MHDcb;
    private javax.swing.JComboBox<String> MSPcb;
    private javax.swing.JTextField Macthdtxt;
    private javax.swing.JTextField Mahdtxt;
    private javax.swing.JComboBox<String> Makhcb;
    private javax.swing.JComboBox<String> Manvcb;
    private javax.swing.JTextField Ngaynhaptxt;
    private javax.swing.JTextField Soluongtxt;
    private javax.swing.JButton Suabtn;
    private javax.swing.JButton Suahdbtn;
    private javax.swing.JTextField Thanhtientxt;
    private javax.swing.JButton Thanhtoanbtn;
    private javax.swing.JButton Thembtn;
    private javax.swing.JButton Themhdbtn;
    private javax.swing.JButton Xoabtn;
    private javax.swing.JButton Xoahdbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
