package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/getAllBook")
    public ResponseEntity<List<Book>> getAllBook(){
        return bookService.getAllBook();
    }
    @GetMapping("/getBookById")
    public ResponseEntity<Book> getBookById(@RequestParam Integer id){
        return bookService.getBookById(id);
    }
    @PostMapping("/saveBook")
    public ResponseEntity<Book> saveBook(@RequestBody BookDto bookDto){
        return bookService.saveBook(bookDto);
    }
}
