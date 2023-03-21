package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.entity.Category;
import peaksoft.repository.CategoryRepository;
import peaksoft.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getByIdCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public Category updateByIdCategory(Long categoryId, Category category) {
        Category category1 = getByIdCategory(categoryId);
        category1.setName(category.getName());
        categoryRepository.save(category1);
        return category1;
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
