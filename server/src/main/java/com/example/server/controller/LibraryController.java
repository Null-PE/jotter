package com.example.server.controller;

import com.example.server.entity.Book;
import com.example.server.entity.Category;
import com.example.server.service.BookService;
import com.example.server.service.CategoryService;
import com.example.server.util.FileCommon;
import com.example.server.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class LibraryController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        }
        return list();
    }

    @GetMapping("/api/categories")
    public List<Category> listCategory() throws Exception {
        List<Category> categories = categoryService.list();
        System.out.println("get categories [" + categories.size() + "]");
        return categories;
    }

    @PostMapping("api/covers")
    public String coverUpload(MultipartFile file) throws Exception {
        File imageFolder = new File(FileCommon.FILE_PATH);
        File f = new File(imageFolder, StringUtils.getRandomString(6) +
                file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            return "http://localhost:8443/api/file/" + f.getName();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
