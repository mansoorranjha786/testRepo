package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public ResponseEntity<List<Book>> getAllBook() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    public ResponseEntity<Book> getBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Book> saveBook(BookDto bookDto) {
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setDescription(bookDto.getDescription());
        book.setAuthorName(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        return ResponseEntity.ok(bookRepository.save(book));
    }
}
