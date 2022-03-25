package com.example.server.service;

import com.example.server.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();

    Category get(int id);
}
