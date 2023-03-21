package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entity.StopList;

import java.util.List;

@Repository
public interface StopListRepository extends JpaRepository<StopList, Long> {
    @Query("select s from StopList s where s.menuItem.id=:menuItemId")
    List<StopList>getAllStopList(Long menuItemId);
}