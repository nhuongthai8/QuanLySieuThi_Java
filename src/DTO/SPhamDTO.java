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
public class SPhamDTO {
    private String MaSP,TenSP,MaNCC,HSD,MaLoai;
    private int SoLuong;
    private float GiaTien;
    private Date date;
    private NhCCDTO nccdto;
    private LoaiSPDTO lspdto;

    public SPhamDTO() {
    }

    public SPhamDTO(String MaSP) {
        this.MaSP = MaSP;
    }

    public SPhamDTO(String MaSP, String TenSP, String MaNCC, String HSD, String MaLoai, int SoLuong, float GiaTien, Date date, NhCCDTO nccdto, LoaiSPDTO lspdto) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaNCC = MaNCC;
        this.HSD = HSD;
        this.MaLoai = MaLoai;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.date = date;
        this.nccdto = nccdto;
        this.lspdto = lspdto;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NhCCDTO getNccdto() {
        return nccdto;
    }

    public void setNccdto(NhCCDTO nccdto) {
        this.nccdto = nccdto;
    }

    public LoaiSPDTO getLspdto() {
        return lspdto;
    }

    public void setLspdto(LoaiSPDTO lspdto) {
        this.lspdto = lspdto;
    }

    

    
    
}
