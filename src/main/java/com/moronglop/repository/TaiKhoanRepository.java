package com.moronglop.repository;

import com.moronglop.model.TaiKhoan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaiKhoanRepository extends CrudRepository<TaiKhoan,Integer> {
    TaiKhoan findByUsername(String username);
}
