package com.example.server.service;

import com.example.server.dao.CategoryDAO;
import com.example.server.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list(){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return categoryDAO.findAll(sort);
    }

    public Category get(int id) {
        return categoryDAO.findById(id).orElse(null);
    }
}
