package com.hbpractice.ManyToManyMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpractice.ManyToManyMapping.entity.BookReferred;

public interface BookReferredRepository extends JpaRepository<BookReferred, Integer> {

}
