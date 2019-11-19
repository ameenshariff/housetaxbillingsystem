package com.as.housetaxbillingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.housetaxbillingsystem.entity.Login;

public interface LoginRepo extends JpaRepository<Login, String> {

}
