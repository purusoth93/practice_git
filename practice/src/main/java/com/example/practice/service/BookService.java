package com.example.practice.service;

import java.util.List;

import com.example.practice.dto.BookDTO;
import com.example.practice.utility.LibraryException;

public interface BookService {
	List<BookDTO> getBooks() throws LibraryException;
	String createBooks(List<BookDTO> books) throws LibraryException;	
	String createBook(BookDTO book) throws LibraryException;
}
