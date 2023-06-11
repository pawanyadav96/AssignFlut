package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.salesOrder;

public interface salesRepo extends JpaRepository<salesOrder, Integer>{

}
