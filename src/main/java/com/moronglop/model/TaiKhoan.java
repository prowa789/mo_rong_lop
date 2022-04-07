package com.moronglop.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.*;


@Data
@Entity
@RequiredArgsConstructor
@Table(name="tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "id_vai_tro")
    private VaiTro vaiTro;

    public boolean hasRole(String tenVaiTro) {
            if (vaiTro.getTen().equals(tenVaiTro)) {
                return true;
            }
        return false;

    }
}
