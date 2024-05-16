package com.hbpractice.ManyToManyMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbpractice.ManyToManyMapping.entity.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {

}
