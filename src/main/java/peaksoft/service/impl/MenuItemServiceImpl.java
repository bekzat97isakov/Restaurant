package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.MenuItem;
import peaksoft.repository.MenuItemRepository;
import peaksoft.service.MenuItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {
    private final MenuItemRepository menuItemRepository;

    @Override
    public MenuItem saveMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
        return menuItem;
    }

    @Override
    public List<MenuItem> getAllMenuItem() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getByIdMenuItem(Long menuItemId) {
        return menuItemRepository.findById(menuItemId).get();
    }

    @Override
    @Transactional
    public MenuItem updateByIdMenuItem(Long menuItemId, MenuItem menuItem) {
        MenuItem menuItem1 = getByIdMenuItem(menuItemId);
        menuItem1.setName(menuItem.getName());
        menuItem1.setImage(menuItem.getImage());
        menuItem1.setPrice(menuItem.getPrice());
        menuItem1.setDescription(menuItem.getDescription());
        menuItem1.setIsVegetarian(menuItem.getIsVegetarian());
        menuItemRepository.save(menuItem1);
        return menuItem1;
    }

    @Override
    public void deleteByIdMenuItem(Long menuItemId) {
        menuItemRepository.deleteById(menuItemId);
    }
}
