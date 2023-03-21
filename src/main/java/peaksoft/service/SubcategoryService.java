package peaksoft.service;

import peaksoft.entity.Subcategory;

import java.util.List;

public interface SubcategoryService {
    Subcategory saveSubCategory(Subcategory subcategory);
    List<Subcategory> getAllSubcategory();
    Subcategory getByIdSubcategory(Long subcategoryId);
    Subcategory updateByIdSubcategory(Long subcategoryId, Subcategory subcategory);
    void deleteSubcategory(Long subcategoryId);
}
