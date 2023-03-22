package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.StopListResponse;
import peaksoft.entity.StopList;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface StopListRepository extends JpaRepository<StopList, Long> {
    @Query("select new peaksoft.dto.response.StopListResponse(s.reason,s.date,s.menuItem.name)from  StopList s where s.id=:id")
    StopListResponse getByStopListId(Long id);
    @Query("select new peaksoft.dto.response.StopListResponse(s.reason,s.date,s.menuItem.name)from  StopList s")
    Set<StopListResponse> getAll();
    @Query("select count(*) from StopList s where s.date =:date and upper(s.menuItem.name) like upper(:menuItemName)")
    Integer counts(LocalDate date, String menuItemName);
}