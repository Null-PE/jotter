package com.example.server.service;

import com.example.server.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> list();

    void addOrUpdate(Book book);

    void deleteById(int id);

    List<Book> listByCategory(int cid);
}
