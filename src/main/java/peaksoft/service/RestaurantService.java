package peaksoft.service;

import peaksoft.dto.request.RestaurantRequest;
import peaksoft.dto.response.RestaurantResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Restaurant;

public interface RestaurantService {
    SimpleResponse saveRestaurant(RestaurantRequest restaurantRequest);

    RestaurantResponse getAllRestaurant();
    SimpleResponse updateRestaurantById(Long id,RestaurantRequest restaurantRequest);
    SimpleResponse deleteRestaurant(Long id);
    String count();
}
