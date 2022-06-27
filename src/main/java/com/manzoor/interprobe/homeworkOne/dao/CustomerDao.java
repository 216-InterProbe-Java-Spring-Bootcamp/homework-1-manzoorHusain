package com.manzoor.interprobe.homeworkOne.dao;

import com.manzoor.interprobe.homeworkOne.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {
}
