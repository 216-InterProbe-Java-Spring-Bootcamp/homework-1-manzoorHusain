package com.manzoor.interprobe.homeworkOne.dao;

import com.manzoor.interprobe.homeworkOne.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentDao extends JpaRepository<ProductComment ,Long> {
}
