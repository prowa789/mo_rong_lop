package com.moronglop.repository;

import com.moronglop.model.VaiTro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaiTroRepository extends CrudRepository<VaiTro,Integer> {
}
