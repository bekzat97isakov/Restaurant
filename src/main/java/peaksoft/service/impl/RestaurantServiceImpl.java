package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Restaurant;
import peaksoft.repository.RestaurantRepository;
import peaksoft.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getByIdRestaurant(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).get();
    }

    @Override
    @Transactional
    public Restaurant updateRestaurantById(Long restaurantId,Restaurant restaurant) {
        Restaurant restaurant1 = getByIdRestaurant(restaurantId);
        restaurant1.setName(restaurant.getName());
        restaurant1.setLocation(restaurant.getLocation());
        restaurant1.setRestType(restaurant.getRestType());
        restaurant1.setNumberOfEmployees(restaurant.getNumberOfEmployees());
        restaurant1.setService(restaurant.getService());
        restaurantRepository.save(restaurant1);
        return restaurant1;
    }

    @Override
    public void deleteRestaurantById(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }
}
