package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Subcategory;
import peaksoft.repository.SubcategoryRepository;
import peaksoft.service.SubcategoryService;

import java.util.List;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    @Autowired
    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public Subcategory saveSubCategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public List<Subcategory> getAllSubcategory() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Subcategory getByIdSubcategory(Long subcategoryId) {
        return subcategoryRepository.findById(subcategoryId).get();
    }

    @Override
    public Subcategory updateByIdSubcategory(Long subcategoryId, Subcategory subcategory) {
        Subcategory subcategory1 = getByIdSubcategory(subcategoryId);
        subcategory1.setName(subcategory.getName());
        subcategoryRepository.save(subcategory1);
        return subcategory1;
    }

    @Override
    public void deleteSubcategory(Long subcategoryId) {
        subcategoryRepository.deleteById(subcategoryId);
    }
}
