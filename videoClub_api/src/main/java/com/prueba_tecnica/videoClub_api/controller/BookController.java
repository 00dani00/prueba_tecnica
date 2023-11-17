package com.prueba_tecnica.videoClub_api.controller;

import com.prueba_tecnica.videoClub_api.modelo.Book;
import com.prueba_tecnica.videoClub_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/book")
    public List<Book> listBooks(){
        return service.listBooks();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> book(@PathVariable Integer id){
        try {
            Book book = service.getBookById(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        try {
            service.saveBook(book);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Integer id){
        try {
            service.updateBook(book, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id){
        try {
            Book book = service.getBookById(id);
            service.deleteBook(id);
            return new ResponseEntity<Book>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }
}
