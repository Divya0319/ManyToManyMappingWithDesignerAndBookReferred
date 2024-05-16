package com.hbpractice.ManyToManyMapping;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbpractice.ManyToManyMapping.entity.BookReferred;
import com.hbpractice.ManyToManyMapping.entity.BookReview;
import com.hbpractice.ManyToManyMapping.entity.Coder;
import com.hbpractice.ManyToManyMapping.entity.CoderDetail;
import com.hbpractice.ManyToManyMapping.entity.Designer;
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
	private final DesignerRepository designerRepository;
	
	@Autowired
	public SampleDataInitializer(CoderRepository coderRepository, CoderDetailRepository coderDetailRepository,
			BookReferredRepository bookReferredRepository, BookReviewRepository bookReviewRepository,
			DesignerRepository designerRepository) {
		this.coderRepository = coderRepository;
		this.coderDetailRepository = coderDetailRepository;
		this.bookReferredRepository = bookReferredRepository;
		this.designerRepository = designerRepository;
	}
	
	@PostConstruct
	public void init() {
		insertIntoEntitiesOneByOne();
	}
	

	private void insertIntoEntitiesOneByOne() {
		// Sample data for CoderDetail
        String[] githubProfileUrls = {
            "https://github.com/johndoe",
            "https://github.com/alicesmith",
            "https://github.com/bobjohnson",
            "https://github.com/emilybrown",
            "https://github.com/michaeldavis"
        };
        int[] soReps = {1500, 2000, 1800, 1200, 2500};

        // Sample data for Coder
        String[] firstNames = {"John", "Alice", "Bob", "Emily", "Michael"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Brown", "Davis"};
        int[] ages = {30, 25, 28, 35, 40};
        String[] emails = {"john.doe@example.com", "alice.smith@example.com", "bob.johnson@example.com", "emily.brown@example.com",
        		"michael.davis@example.com"};
        
        // Sample data for Designer
        String[] firstNamesDes = {"Sarah", "David", "Emma", "Ryan", "Olivia"};
        String[] lastNamesDes = {"Wilson", "Jones", "Taylor", "Clark", "Anderson"};
        String[] emailsDes = {
        	    "sarah.wilson@example.com",
        	    "david.jones@example.com",
        	    "emma.taylor@example.com",
        	    "ryan.clark@example.com",
        	    "olivia.anderson@example.com"
        	};
        
        // Sample data for Book
        String[] bookTitles = {
                "The Great Gatsby",
                "To Kill a Mockingbird",
                "1984",
                "Pride and Prejudice",
                "The Catcher in the Rye"
            };

        // Sample data for BookReview
        String[] comments = {
            "Great book, highly recommended.",
            "Interesting read, but could use more examples.",
            "Loved it! Can't wait for the sequel.",
            "Informative and well-written.",
            "Not what I expected, but pleasantly surprised."
        };
        

        for (int i = 0; i < 5; i++) {
            // Create and save CoderDetail
            CoderDetail coderDetail = new CoderDetail(githubProfileUrls[i], soReps[i]);

            // Create and save Coder
            Coder coder = new Coder(firstNames[i], lastNames[i], ages[i], emails[i]);
            coder.setCoderDetail(coderDetail);
            
            // Create and save Designer
            Designer designer = new Designer();
            designer.setFirstName(firstNamesDes[i]);
            designer.setLastName(lastNamesDes[i]);
            designer.setEmail(emailsDes[i]);
            
            // Create BookReview 
            BookReview bookReview = new BookReview(comments[i]);
            
            // Add BookReview and Coder to BookReferred(BookReview will be saved because of cascade)
            BookReferred bookReferred = new BookReferred(bookTitles[i]);
            bookReferred.addBookReview(bookReview);
            bookReferred.setCoder(coder);
            coder.addBook(bookReferred);
            
            designer.addBook(bookReferred);
            designerRepository.save(designer);
            
            
        }
		
	}
	

}
