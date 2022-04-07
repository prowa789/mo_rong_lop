package com.moronglop.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@RequiredArgsConstructor

public class SinhVien{
    @Id
    private Integer maSinhVien;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String noiSinh;
    private String khoaHoc;
    private String lopHanhChinh;
    private String chuongTrinhHoc;
    private String dienThoai;
    private String email;
    @OneToOne
    @JoinColumn(name = "id_tai_khoan")
    private TaiKhoan taiKhoan;


    public void updateTtcn(SinhVien sv){
        this.hoTen = sv.hoTen;
        this.gioiTinh = sv.gioiTinh;
        this.ngaySinh = sv.ngaySinh;
        this.noiSinh = sv.noiSinh;
    }
    public void updateTthc(SinhVien sv){
        this.lopHanhChinh = sv.lopHanhChinh;
        this.chuongTrinhHoc = sv.chuongTrinhHoc;
        this.khoaHoc = sv.khoaHoc;
    }

}
