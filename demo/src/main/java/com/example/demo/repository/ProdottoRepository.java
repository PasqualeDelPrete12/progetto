package com.example.demo.repository;

import com.example.demo.entity.ProdottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<ProdottoEntity,Long> {

}
