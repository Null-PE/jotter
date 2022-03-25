package com.example.server.service.impl;

import com.example.server.dao.BookDAO;
import com.example.server.entity.Book;
import com.example.server.entity.Category;
import com.example.server.service.BookService;
import com.example.server.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    private final CategoryService categoryService;

    @Override
    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDAO.findAll(sort);
    }

    @Override
    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    @Override
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }
}
