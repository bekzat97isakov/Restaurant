package peaksoft.service;

import peaksoft.entity.Restaurant;

public interface RestaurantService {
    Restaurant saveRestaurant(Restaurant restaurant);
    Restaurant getByIdRestaurant(Long restaurantId);
    Restaurant updateRestaurantById(Long restaurantId,Restaurant restaurant);
    void deleteRestaurantById(Long restaurantId);
}
