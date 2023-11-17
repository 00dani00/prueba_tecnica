package com.prueba_tecnica.videoClub_api.service;

import com.prueba_tecnica.videoClub_api.modelo.Book;
import com.prueba_tecnica.videoClub_api.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
class BookServiceTest {

    @Mock //objeto mock que va a ser crado por mockito
    private BookRepository bookRepository;
    @InjectMocks  //mocks que van a ser inyectados
    private BookService bookService;

    private Book bookMock = new Book();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        //Persona de prueba
        int id = 1;
        String tittle = "La llorona";
        String author = "El lloron";
        String year_publication  = "2000";
        String genre = "Terror";

        //Variable para realizar el test

        bookMock = new Book(id,tittle,author,year_publication,genre);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listBooks() {
        when(bookRepository.findAll()).thenReturn(Collections.singletonList(bookMock));

        List<Book> book = bookService.listBooks();

        assertEquals(bookMock.getId(), book.get(0).getId());
        assertEquals(bookMock.getTitle(), book.get(0).getTitle());
    }

    @Test
    void saveBook() {
        when(bookRepository.save(any())).thenReturn(bookMock);

        Book book = bookService.saveBook(bookMock);

        assertNotNull(bookService.saveBook(bookMock));
        assertEquals(book.getId(), bookMock.getId());
        assertEquals(book.getTitle(), bookMock.getTitle());
    }

    @Test
    void updateBook() throws Exception {
        when(bookRepository.existsById(1)).thenReturn(true);
        when(bookRepository.save(any())).thenReturn(bookMock);
        Book book = bookService.updateBook(bookMock, bookMock.getId());

        assertNotNull(book);
        assertEquals(book.getId(), bookMock.getId());
        assertEquals(book.getTitle(), bookMock.getTitle());

    }

    @Test
    void getBookById() {
        when(bookRepository.findById(anyInt())).thenReturn(Optional.ofNullable(bookMock));

        Book book = bookService.getBookById(bookMock.getId());

        assertEquals(book.getId(), bookMock.getId());
        assertEquals(book.getTitle(), bookMock.getTitle());
    }

    @Test
    void deleteBook() {
        when(bookRepository.existsById(1)).thenReturn(true);
        doNothing().when(bookRepository).deleteById(1);
        bookService.deleteBook(bookMock.getId());
        assertTrue(bookService.deleteBook(bookMock.getId()));
    }
}