package com.moronglop.repository;

import com.moronglop.model.LopDangKi;
import com.moronglop.model.SinhVien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LopDangKiRepository extends CrudRepository<LopDangKi,String> {
    List<LopDangKi> findAllBySinhVienOrderByThoiGianDKAsc(SinhVien sinhVien);
    long countLopDangKiBySinhVien(SinhVien sinhVien);
}
