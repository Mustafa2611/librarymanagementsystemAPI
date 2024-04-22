package com.BMS.librarymanagementsystem.librarymanagementsystem.service;

import com.BMS.librarymanagementsystem.librarymanagementsystem.exception.ResourceNotFoundException;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.BMS.librarymanagementsystem.librarymanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        Book book = optionalBook.get();
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublicationYear(bookDetails.getPublicationYear());
        book.setIsbn(bookDetails.getIsbn());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
}
