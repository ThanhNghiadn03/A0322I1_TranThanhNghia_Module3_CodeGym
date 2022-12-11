package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BenhAn {
    private String code;
    private int idBenhAn;
    private String tenBenhAn;
    private LocalDate ngayNhapVien;
    private String nhapVien;
    private LocalDate ngayXuatVien;
    private String xuatVien;
    private BenhNhan benhNhan;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public BenhAn(int idBenhAn, String tenBenhAn, String nhapVien, String xuatVien, BenhNhan benhNhan) {
        this.idBenhAn = idBenhAn;
        this.tenBenhAn = tenBenhAn;
        this.nhapVien = nhapVien;
        this.xuatVien = xuatVien;
        this.benhNhan = benhNhan;
        this.ngayNhapVien = LocalDate.parse(nhapVien,formatter);
        this.ngayXuatVien = LocalDate.parse(xuatVien,formatter);
        if (this.idBenhAn <10) {
            this.code = "BA" + "00"+this.idBenhAn;
        } else if (this.idBenhAn < 100) {
            this.code = "BA"+"0"+this.idBenhAn;
        } else {
            this.code = "BA" +this.idBenhAn;
        }
    }

    public BenhAn() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(int idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public String getTenBenhAn() {
        return tenBenhAn;
    }

    public void setTenBenhAn(String tenBenhAn) {
        this.tenBenhAn = tenBenhAn;
    }

    public LocalDate getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = LocalDate.parse(ngayNhapVien,formatter);
    }

    public String getNhapVien() {
        return nhapVien;
    }

    public void setNhapVien(String nhapVien) {
        this.nhapVien = nhapVien;
    }

    public LocalDate getNgayXuatVien() {
        return ngayXuatVien;
    }

    public void setNgayXuatVien(String ngayXuatVien) {
        this.ngayXuatVien = LocalDate.parse(ngayXuatVien,formatter);
    }

    public String getXuatVien() {
        return xuatVien;
    }

    public void setXuatVien(String xuatVien) {
        this.xuatVien = xuatVien;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateTimeFormatter formatter) {
        BenhAn.formatter = formatter;
    }
}
