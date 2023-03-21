package peaksoft.service;

import peaksoft.entity.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategory();
    Category getByIdCategory(Long categoryId);
    Category updateByIdCategory(Long categoryId, Category category);
    void deleteCategoryById(Long categoryId);
}
