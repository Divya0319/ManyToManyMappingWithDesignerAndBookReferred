package com.hbpractice.ManyToManyMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpractice.ManyToManyMapping.entity.Coder;

public interface CoderRepository extends JpaRepository<Coder, Integer> {

}
