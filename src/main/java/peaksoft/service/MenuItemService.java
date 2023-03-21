package peaksoft.service;

import peaksoft.entity.MenuItem;

import java.util.List;

public interface MenuItemService {
    MenuItem saveMenuItem(MenuItem menuItem);
    List<MenuItem> getAllMenuItem();
    MenuItem getByIdMenuItem(Long menuItemId);
    MenuItem updateByIdMenuItem(Long menuItemId,MenuItem menuItem);
    void deleteByIdMenuItem(Long menuItemId);
}
