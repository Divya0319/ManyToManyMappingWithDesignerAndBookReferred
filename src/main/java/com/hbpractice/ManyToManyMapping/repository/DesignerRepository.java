package com.hbpractice.ManyToManyMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpractice.ManyToManyMapping.entity.Designer;

public interface DesignerRepository extends JpaRepository<Designer, Integer> {

}
