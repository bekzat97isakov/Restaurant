package peaksoft.dto.response;

import java.math.BigDecimal;

public class MenuItemResponseSearch {
    private String categoryName;
    private String subcategoryName;
    private String menuItemName;
    private String menuItemImage;
    private BigDecimal menuItemPrice;

    public MenuItemResponseSearch(String categoryName, String subcategoryName, String menuItemName, String menuItemImage, BigDecimal menuItemPrice) {
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
        this.menuItemName = menuItemName;
        this.menuItemImage = menuItemImage;
        this.menuItemPrice = menuItemPrice;
    }

    // Getters and setters

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getMenuItemImage() {
        return menuItemImage;
    }

    public void setMenuItemImage(String menuItemImage) {
        this.menuItemImage = menuItemImage;
    }

    public BigDecimal getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(BigDecimal menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }
}
