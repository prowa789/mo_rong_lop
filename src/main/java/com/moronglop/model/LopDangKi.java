package com.moronglop.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor

@Table(name = "lop_tc_dk")
public class LopDangKi {
    @Id
    private String id;
    @Column(name = "ma_hoc_phan")
    private String maHocPhan;
    @Column(name = "ten_hoc_phan")
    private String tenHocPhan;
    @Column(name = "ly_do")
    private String lyDo;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @Column(name = "ma_lop_dang_ki")
    private String maLopDangKi;
    @Column(name = "ma_lop_cu")
    private String maLopCu;
    @Column(name = "thoi_gian_dk")
    private Date thoiGianDK;
    @Column(name = "thoi_gian_duyet")
    private Date thoiGianDuyet;
    @Column(name = "phan_hoi")
    private String phanHoi;
    @ManyToOne
    @JoinColumn(name = "ma_sinh_vien")
    private SinhVien sinhVien;

    @PrePersist
    void prePresit(){
        id = UUID.randomUUID().toString();
        this.thoiGianDK = new Date();
    }

    public void updateThongTinDK(LopDangKi lopDangKi){

        this.lyDo = lopDangKi.lyDo;
        this.maLopCu = lopDangKi.maLopCu;
        this.maHocPhan = lopDangKi.maHocPhan;
        this.maLopDangKi = lopDangKi.maLopDangKi;
        this.tenHocPhan = lopDangKi.tenHocPhan;
    }
}
