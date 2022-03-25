package com.example.server.service.impl;

import com.example.server.dao.CategoryDAO;
import com.example.server.entity.Category;
import com.example.server.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    @Override
    public List<Category> list(){
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return categoryDAO.findAll(sort);
    }

    @Override
    public Category get(int id) {
        return categoryDAO.findById(id).orElse(null);
    }
}
