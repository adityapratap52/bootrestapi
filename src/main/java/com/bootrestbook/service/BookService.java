package com.bootrestbook.service;

import com.bootrestbook.dao.BookRepository;
import com.bootrestbook.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

//    private static List<Book> books = new ArrayList<>();
//
//    static {
//        books.add(new Book(11,"C",134.50));
//        books.add(new Book(12,"Java",200));
//        books.add(new Book(13,"Python",160.50));
//    }

            // retrieve all books
    public List<Book> getBooks() {
//        return books;

        List<Book> list = (List<Book>) repository.findAll();
        return list;
    }

            // retrieve book by id
    public Book getById(int id) {
        Book book = null;
        try {

//            book = books.stream().filter(e -> e.getId() == id).findFirst().get();

            book = repository.findById(id).get();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // adding a book
    public Book addBook(Book book) {
//        books.add(book);

        Book book1 = repository.save(book);
        return book1;
    }

    // deleting a book
    public void deleteBook(int id) {
//        books = books.stream().filter(book -> book.getId() != id).collect(Collectors.toList());

        repository.deleteById(id);
    }

    // update a book
    public void updateBook(Book book, int id) {
//        books = books.stream().map(b ->{
//            if (b.getId() == id)
//            {
//                b.setName(book.getName());
//                b.setPrice(book.getPrice());
//            }
//          return b;
//        }).collect(Collectors.toList());

        book.setId(id);
        repository.save(book);
    }
}
