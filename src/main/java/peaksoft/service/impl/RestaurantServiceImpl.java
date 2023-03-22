package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.RestaurantRequest;
import peaksoft.dto.response.RestaurantResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.entity.Restaurant;
import peaksoft.entity.enums.Role;
import peaksoft.repository.RestaurantRepository;
import peaksoft.repository.UserRepository;
import peaksoft.service.RestaurantService;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Override
    public SimpleResponse saveRestaurant(RestaurantRequest restaurantRequest) {
        if (!restaurantRepository.existsRestaurant()){
            Restaurant restaurant = new Restaurant();
            restaurant.setName(restaurantRequest.name());
            restaurant.setLocation(restaurantRequest.location());
            restaurant.setRestType(restaurantRequest.restType());
            restaurant.setService(restaurantRequest.service());
            restaurant.setNumberOfEmployees(userRepository.findAllUsers().size());
            restaurantRepository.save(restaurant);
        }else {
            return new SimpleResponse(HttpStatus.FORBIDDEN,"The restaurant already exists!");
        }
        return SimpleResponse.builder().status(HttpStatus.OK)
                .message("Successfully saved").build();
    }

    @Override
    public RestaurantResponse getAllRestaurant() {
        return restaurantRepository.findAllRestaurants();
    }

    @Override
    public SimpleResponse updateRestaurantById(Long id, RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Null"));
        restaurant.setName(restaurantRequest.name());
        restaurant.setLocation(restaurantRequest.location());
        restaurant.setRestType(restaurantRequest.restType());
        restaurantRepository.save(restaurant);
        return new SimpleResponse(HttpStatus.OK,"Successfully update!");
    }

    @Override
    public SimpleResponse deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
        return new SimpleResponse(HttpStatus.OK,"Successfully delete");
    }

    @Override
    public String count() {
        Set<UserResponse> allUsers = userRepository.findAllUsers(restaurantRepository.findRestaurant().getId());
        int countChef=0;
        int countWaiter=0;
        for (UserResponse u: allUsers){
            if (u.role().equals(Role.Walter)){
                countWaiter++;
            }
            if (u.role().equals(Role.Chef)){
                countChef++;
            }
        }
        return "Currently the restaurant has "+allUsers.size()+" employees .\n" +
                "Chefs: "+countChef
                +"\nWaiters: "+countWaiter;
    }
}
