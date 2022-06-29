/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ChiTietHDDTO {
    private String MaCTHD,MaHD,MaSP;
    private float GiaTien;
    private int SoLuong,ThanhTien;
    private Date NgayNhap;
    private LoaiSPDTO lsp;
    private SPhamDTO sp;

    public ChiTietHDDTO() {
    }

    public ChiTietHDDTO(String MaCTHD, String MaHD, String MaSP, float GiaTien, int SoLuong, int ThanhTien, Date NgayNhap, LoaiSPDTO lsp, SPhamDTO sp) {
        this.MaCTHD = MaCTHD;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.GiaTien = GiaTien;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.NgayNhap = NgayNhap;
        this.lsp = lsp;
        this.sp = sp;
    }

    public String getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(String MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public LoaiSPDTO getLsp() {
        return lsp;
    }

    public void setLsp(LoaiSPDTO lsp) {
        this.lsp = lsp;
    }

    public SPhamDTO getSp() {
        return sp;
    }

    public void setSp(SPhamDTO sp) {
        this.sp = sp;
    }

}
