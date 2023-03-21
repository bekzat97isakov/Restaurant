package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}