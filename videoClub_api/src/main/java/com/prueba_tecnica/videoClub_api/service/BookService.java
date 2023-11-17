package com.prueba_tecnica.videoClub_api.service;

import com.prueba_tecnica.videoClub_api.modelo.Book;
import com.prueba_tecnica.videoClub_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> listBooks(){ return repository.findAll(); }
    public Book saveBook(Book book){
        return repository.save(book);
    }
    public Book updateBook(Book book, int id) throws Exception {
        if(repository.existsById(id)){
            return repository.save(book);
        }
        else{
            throw new Exception("No existe el libro");
        }
    }
    public Book getBookById(Integer id){
        return repository.findById(id).get();
    }
    public boolean deleteBook(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
