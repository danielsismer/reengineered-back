package com.weg.reenginered.domain.port;

import com.weg.reenginered.domain.dto.filter.CategoryFilter;
import com.weg.reenginered.domain.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryPort {

    Category save(Category category);
    Category listById(Long id);
    List<Category> listAll(CategoryFilter categoryFilter);
    Category update(Category category, Long id);
    void deleteById(Long id);
}
