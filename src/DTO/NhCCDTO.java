/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class NhCCDTO {
    private String TenNCC,MaNCC,DiaChi,SDT,Email;

    public NhCCDTO() {
    }

    public NhCCDTO(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public NhCCDTO(String TenNCC, String MaNCC, String DiaChi, String SDT, String Email) {
        this.TenNCC = TenNCC;
        this.MaNCC = MaNCC;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    
}
