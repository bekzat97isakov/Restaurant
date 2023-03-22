package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.MenuItemRequest;
import peaksoft.dto.response.MenuItemResponse;
import peaksoft.dto.response.MenuItemResponseSearch;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.service.MenuItemService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/menu-items")
@RequiredArgsConstructor
public class MenuItemApi {
    private final MenuItemService menuItemService;

    @PreAuthorize("hasAnyAuthority('CHEF','ADMIN')")
    @PostMapping
    public SimpleResponse saveMenu(@RequestBody MenuItemRequest menuItemRequest) {
        return menuItemService.saveMenuItem(menuItemRequest);
    }
    @GetMapping
    @PreAuthorize("permitAll()")
    public Set<MenuItemResponse> getAllMenu() {
        return menuItemService.getAllMenu();
    }
    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public MenuItemResponse getById(@PathVariable Long id){
        return menuItemService.getById(id);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CHEF','ADMIN')")
    public SimpleResponse updateMenu(@PathVariable Long id,@RequestBody MenuItemRequest menuItemRequest){
        return menuItemService.updateMenuItem(id, menuItemRequest);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CHEF','ADMIN')")
    public  SimpleResponse deleteMenu(@PathVariable Long id){
        return menuItemService.deleteMenu(id);
    }

    @GetMapping("/{sort}")
    @PreAuthorize("permitAll()")
    public Set<MenuItemResponse> sort(@PathVariable("sort") String ascDesc){
        return menuItemService.sort(ascDesc);
    }

    @GetMapping("/filter")
    @PreAuthorize("permitAll()")
    public Set<MenuItemResponse> filter(){
        return menuItemService.filterIsVegetarian();
    }

    @GetMapping("/search")
    @PreAuthorize("permitAll()")
    public Set<MenuItemResponseSearch>search(@RequestParam String search){
        return menuItemService.search(search);

    }

//    @GetMapping("/search")
//    public ResponseEntity<List<MenuItemResponseSearch>> searchMenuItems(@RequestParam String keyword) {
//        List<MenuItemResponseSearch> menuItems = menuItemService.globalSearch(keyword);
//        return ResponseEntity.ok().body(menuItems);
//    }
}
