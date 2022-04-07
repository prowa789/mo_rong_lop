package com.moronglop.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "giao_vu")
public class GiaoVu {
    @Id
    private String maGiaoVu;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "chuc_vu")
    private String chucVu;
    @Column(name = "noi_lam_viec")
    private String noiLamViec;
    @OneToOne
    @JoinColumn(name = "id_tai_khoan")
    private TaiKhoan taiKhoan;

    public void updateThongTin(GiaoVu giaoVu){
        this.sdt = sdt;
        this.chucVu = chucVu;
        this.noiLamViec = noiLamViec;
    }
}
