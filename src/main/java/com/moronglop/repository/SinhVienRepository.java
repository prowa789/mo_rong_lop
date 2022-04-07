package com.moronglop.repository;

import com.moronglop.model.SinhVien;
import com.moronglop.model.TaiKhoan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SinhVienRepository extends CrudRepository<SinhVien,Integer> {
    SinhVien findByTaiKhoan(TaiKhoan taikhoan);
}
