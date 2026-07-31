package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.BookDTO;
import com.example.practice.service.BookService;
import com.example.practice.utility.LibraryException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin
public class BookController {
	
//	@Autowired
//	private BookService bookService;
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	@GetMapping("/getBooks")
	public ResponseEntity<List<BookDTO>> getBooks() throws LibraryException{
		return new ResponseEntity<>( bookService.getBooks(),HttpStatus.OK);
	}
	
	@PostMapping("/createBooks")
	public ResponseEntity<String> createBooks(@RequestBody List<@Valid BookDTO> bookDTO) throws LibraryException{
		return new ResponseEntity<>(bookService.createBooks(bookDTO),HttpStatus.CREATED);
	}
	
	@PostMapping("/createBook")
	public ResponseEntity<String> createBook(@Valid @RequestBody BookDTO bookDTO) throws LibraryException{
		return new ResponseEntity<>(bookService.createBook(bookDTO),HttpStatus.CREATED);
	}
	
}
