package com.hbpractice.ManyToManyMapping;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbpractice.ManyToManyMapping.dao.CoderDAO;
import com.hbpractice.ManyToManyMapping.entity.Coder;
import com.hbpractice.ManyToManyMapping.repository.BookReferredRepository;
import com.hbpractice.ManyToManyMapping.repository.BookReviewRepository;
import com.hbpractice.ManyToManyMapping.repository.CoderDetailRepository;
import com.hbpractice.ManyToManyMapping.repository.CoderRepository;
import com.hbpractice.ManyToManyMapping.repository.DesignerRepository;

@Component
public class SampleDataInitializer {
	
	private final CoderRepository coderRepository;
	private final CoderDetailRepository coderDetailRepository;
	private final BookReferredRepository bookReferredRepository;
	private final BookReviewRepository bookReviewRepository;
	private final DesignerRepository designerRepository;
	
	@Autowired
	public SampleDataInitializer(CoderRepository coderRepository, CoderDetailRepository coderDetailRepository,
			BookReferredRepository bookReferredRepository, BookReviewRepository bookReviewRepository,
			DesignerRepository designerRepository) {
		this.coderRepository = coderRepository;
		this.coderDetailRepository = coderDetailRepository;
		this.bookReferredRepository = bookReferredRepository;
		this.bookReviewRepository = bookReviewRepository;
		this.designerRepository = designerRepository;
	}
	
	@PostConstruct
	public void init() {
		insertCoderData();
        insertCoderDetailData();
		insertBookReferredData();
		insertBookReviewData();
        insertDesignerData();
        insertBookReferredDesignerData();
	}

	private void insertCoderData() {
	    // Insert sample data into coder table
		
	}
		
	private void insertCoderDetailData() {
	// Insert sample data into coder_detail table
	}
	
	private void insertBookReferredData() {
	// Insert sample data into book_referred table
	}
	
	private void insertBookReviewData() {
	// Insert sample data into book_review table
	}
	
	private void insertDesignerData() {
    // Insert sample data into designer table

	}
	
	private void insertBookReferredDesignerData() {
	// Insert sample data into book_referred_designer table
    // This table is a many-to-many relationship between BookReferred and Designer
    
	}

}
