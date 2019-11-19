package com.as.housetaxbillingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.housetaxbillingsystem.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {

}
