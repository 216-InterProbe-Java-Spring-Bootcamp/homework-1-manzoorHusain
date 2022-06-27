package com.manzoor.interprobe.homeworkOne.dao;

import com.manzoor.interprobe.homeworkOne.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {
}
