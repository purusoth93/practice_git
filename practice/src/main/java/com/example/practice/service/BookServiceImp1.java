package com.example.practice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.practice.dto.BookDTO;
import com.example.practice.entity.Books;
import com.example.practice.repository.BookRepository;
import com.example.practice.utility.LibraryException;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class BookServiceImp1 implements BookService {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookDTO> getBooks() throws LibraryException {
		
		List<Books> books=bookRepository.findAll();
		
		if(books.isEmpty()) {
			throw new LibraryException(environment.getProperty("books.empty"));
		}
		
		return books.stream().map(b->{
			BookDTO book = new BookDTO();
			book.setDescription(b.getDescription());
			book.setId(b.getId());
			book.setName(b.getName());
			return book;
		}).toList();
	}

	@Override
	public String createBooks(List<BookDTO> bookDTO) throws LibraryException {
		if(bookDTO.isEmpty()) {
			throw new LibraryException(environment.getProperty("books.list.invalid"));
		}
		List<Books> books=bookDTO.stream().map(b->{
			Books book = new Books();
			book.setDescription(b.getDescription());
			book.setName(b.getName());
			return book;
			
		}).toList();
		
		bookRepository.saveAll(books);
		
		return bookDTO.size()+" added successfully!";
	}

	@Override
	public String createBook(BookDTO bookDTO) throws LibraryException {
		if(bookRepository.findByName(bookDTO.getName()).isPresent()) {
			throw new LibraryException(environment.getProperty("book.not.found"));
		}
		Books book = new Books();
		book.setDescription(bookDTO.getDescription());
		book.setName(bookDTO.getName());
		
		bookRepository.save(book);
		return "Book Created Successfully!!";
	}

}
