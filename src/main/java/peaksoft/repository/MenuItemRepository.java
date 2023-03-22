package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.MenuItemResponse;
import peaksoft.dto.response.MenuItemResponseSearch;
import peaksoft.entity.MenuItem;

import java.util.List;
import java.util.Set;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    @Query("select new peaksoft.dto.response.MenuItemResponse(m.name,m.image,m.price,m.description,m.isVegetarian)from MenuItem  m")
    Set<MenuItemResponse>findAllMenu();
    @Query("select new peaksoft.dto.response.MenuItemResponse(m.name,m.image,m.price,m.description,m.isVegetarian)from MenuItem  m where m.id=:id")
    MenuItemResponse findByMenuId(Long id);

    @Query("select new peaksoft.dto.response.MenuItemResponse(s.name,s.image,s.price,s.description,s.isVegetarian)from MenuItem s order by s.price")
    Set<MenuItemResponse> ascSort();
    @Query("select new peaksoft.dto.response.MenuItemResponse(s.name,s.image,s.price,s.description,s.isVegetarian)from MenuItem s order by s.price desc ")
    Set<MenuItemResponse> descSort();
    MenuItem findByName(String name);
    @Query("select mi from MenuItem mi join mi.cheques c WHERE c.id = :chequeId")
    Set<MenuItem> findAllByChequeId(Long chequeId);

    @Query("SELECT new peaksoft.dto.response.MenuItemResponseSearch(c.name,s.name,m.name,m.price) FROM MenuItem  m join  m.subcategory s join s.category c where m.name ilike concat('%',:search,'%') or s.name ilike concat('%',:search,'%') or c.name ILIKE concat('%',:search,'%')")
    Set<MenuItemResponseSearch> searchBySubcategories(String search);

//    @Query("SELECT new peaksoft.dto.response.menuItem.MenuItemResponseSearch(c.name,s.name,mi.name,mi.image,mi.price) FROM MenuItem mi join mi.subcategories s join s.category c where (mi.name ILIKE %:keyWord% OR c.name ILIKE %:keyWord% OR s.name ILIKE %:keyWord%)")
//    List<MenuItemResponseSearch> globalSearch(@Param("keyWord") String keyword);
}
