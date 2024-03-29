/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NhCCDAO;
import DTO.NhCCDTO;
import Misc.MiscData;
import Misc.MiscDialog;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class NhaCungCap extends javax.swing.JFrame {

    private DefaultTableModel model;
    /**
     * Creates new form NhaCungCap
     */
    public NhaCungCap() {
        initComponents();
        showTable();
        showDatabase();
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
        jTable1 = new javax.swing.JTable();
        Backbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Sdttxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Emailtxt = new javax.swing.JTextField();
        Diachitxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Tenncctxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Mancctxt = new javax.swing.JTextField();
        Thembtn = new javax.swing.JButton();
        Suabtn = new javax.swing.JButton();
        Xoabtn = new javax.swing.JButton();
        Huybtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm Nhà Cung Cấp");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, 750, 260));

        Backbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_back_to_20px.png"))); // NOI18N
        Backbtn.setText("Trở về");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 547, -1, 39));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SĐT:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên NCC:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã NCC:");

        Thembtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thembtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_plus_+_20px.png"))); // NOI18N
        Thembtn.setText("Thêm");
        Thembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThembtnActionPerformed(evt);
            }
        });

        Suabtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Suabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_change_20px_1.png"))); // NOI18N
        Suabtn.setText("Sửa");
        Suabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuabtnActionPerformed(evt);
            }
        });

        Xoabtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Xoabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_minus_20px.png"))); // NOI18N
        Xoabtn.setText("Xóa");
        Xoabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoabtnActionPerformed(evt);
            }
        });

        Huybtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Huybtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_new_copy_20px.png"))); // NOI18N
        Huybtn.setText("Làm mới");
        Huybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuybtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setText("NHÀ CUNG CẤP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(Mancctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37)
                        .addComponent(Sdttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(Tenncctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(Emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(Diachitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(Thembtn)
                .addGap(18, 18, 18)
                .addComponent(Suabtn)
                .addGap(18, 18, 18)
                .addComponent(Xoabtn)
                .addGap(12, 12, 12)
                .addComponent(Huybtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Mancctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Sdttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Tenncctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Diachitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Huybtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(Xoabtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Suabtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Thembtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 250));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NhaCungCap Background.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            Mancctxt.setEnabled(false);
            int row = jTable1.getSelectedRow();
            if(row >=0){
                String id = (String)jTable1.getValueAt(row, 0);
                NhCCDAO dao = new NhCCDAO();
                NhCCDTO ncc = dao.timNCC(id);
                if(ncc != null){
                    Mancctxt.setText(ncc.getMaNCC());
                    Tenncctxt.setText(ncc.getTenNCC());
                    Sdttxt.setText(ncc.getSDT());
                    Diachitxt.setText(ncc.getDiaChi());
                    Emailtxt.setText(ncc.getEmail());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void ThembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThembtnActionPerformed
        StringBuilder sb = new StringBuilder();
        MiscData.DataEmty(Mancctxt, sb, "Vui lòng nhập Mã nhà cung cấp");
        MiscData.DataEmty(Tenncctxt, sb, "Vui lòng nhập Tên nhà cung cấp");
        MiscData.DataEmty(Sdttxt, sb, "Vui lòng nhập SĐT");
        MiscData.DataEmty(Diachitxt, sb, "Vui lòng nhập địa chỉ");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        try{
            NhCCDTO ncc = new NhCCDTO();
            ncc.setMaNCC(Mancctxt.getText());
            ncc.setTenNCC(Tenncctxt.getText());
            ncc.setSDT(Sdttxt.getText());
            ncc.setDiaChi(Diachitxt.getText());
            ncc.setEmail(Emailtxt.getText());

            NhCCDAO nccdao = new NhCCDAO();
            if(nccdao.insertNCC(ncc)){
                MiscDialog.showMessageDialog(null, "Thêm thành công", "Thông báo");
                showDatabase();
                refresh();
            }else{
                MiscDialog.showErrorDialog(null, "Thêm không thành công", "Lỗi");
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_ThembtnActionPerformed

    private void SuabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuabtnActionPerformed
        StringBuilder sb = new StringBuilder();
        MiscData.DataEmty(Mancctxt, sb, "Vui lòng nhập Mã nhà cung cấp");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        if(MiscDialog.showConfirmDialog(null, "Bạn có muốn cập nhật lại không?", "Thông báo") == JOptionPane.NO_OPTION){
            return;
        }
        try{
            NhCCDTO ncc = new NhCCDTO();
            ncc.setMaNCC(Mancctxt.getText());
            ncc.setTenNCC(Tenncctxt.getText());
            ncc.setSDT(Sdttxt.getText());
            ncc.setDiaChi(Diachitxt.getText());
            ncc.setEmail(Emailtxt.getText());

            NhCCDAO nccdao = new NhCCDAO();
            if(nccdao.updateNCC(ncc)){
                MiscDialog.showMessageDialog(null, "Chỉnh sửa thành công", "Thông báo");
                showDatabase();
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
        MiscData.DataEmty(Mancctxt, sb, "Vui lòng nhập Mã nhà cung cấp");
        if(sb.length()>0){
            MiscDialog.showErrorDialog(null, sb.toString(), "Lỗi");
            return;
        }
        if(MiscDialog.showConfirmDialog(null, "Bạn có muốn xóa Nhà cung cấp không?", "Thông báo") == JOptionPane.NO_OPTION){
            return;
        }
        try{
            NhCCDTO ncc = new NhCCDTO();
            ncc.setMaNCC(Mancctxt.getText());
            NhCCDAO nccdao = new NhCCDAO();
            if(nccdao.deleteNCC(ncc)){
                MiscDialog.showMessageDialog(null, "Xóa thành công", "Thông báo");
                showDatabase();
                refresh();
            }else{
                MiscDialog.showErrorDialog(null, "Xóa không thành công", "Lỗi");
            }
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_XoabtnActionPerformed

    private void HuybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuybtnActionPerformed
        Mancctxt.setText("");
        Tenncctxt.setText("");
        Sdttxt.setText("");
        Diachitxt.setText("");
        Emailtxt.setText("");
        Mancctxt.setEnabled(true);
    }//GEN-LAST:event_HuybtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        setVisible(false);
        TrangChuNhCC form = new TrangChuNhCC();
        form.setVisible(true);
    }//GEN-LAST:event_BackbtnActionPerformed

    private void showTable(){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"MÃ NHÀ CUNG CẤP","TÊN NHÀ CUNG CẤP","SĐT","ĐỊA CHỈ","EMAIL"});
        jTable1.setModel(model);
    }
    private void showDatabase(){
        try{
            NhCCDAO dao = new NhCCDAO();
            List<NhCCDTO> list = dao.timNCCAll();
            model.setRowCount(0);
            for(NhCCDTO it : list){
                model.addRow(new Object[]{
                    it.getMaNCC(),it.getTenNCC(),it.getSDT(),it.getDiaChi(),it.getEmail()
                });
            }
            model.fireTableDataChanged();
        }catch(Exception e){
            e.printStackTrace();
            MiscDialog.showErrorDialog(null, e.getMessage(), "Lỗi");
        }
    }
    private void refresh(){
        Mancctxt.setText("");
        Tenncctxt.setText("");
        Sdttxt.setText("");
        Emailtxt.setText("");
        Diachitxt.setText("");
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
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhaCungCap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JTextField Diachitxt;
    private javax.swing.JTextField Emailtxt;
    private javax.swing.JButton Huybtn;
    private javax.swing.JTextField Mancctxt;
    private javax.swing.JTextField Sdttxt;
    private javax.swing.JButton Suabtn;
    private javax.swing.JTextField Tenncctxt;
    private javax.swing.JButton Thembtn;
    private javax.swing.JButton Xoabtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
