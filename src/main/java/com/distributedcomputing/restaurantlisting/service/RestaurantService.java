package com.distributedcomputing.restaurantlisting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.distributedcomputing.restaurantlisting.entity.Restaurant;
import com.distributedcomputing.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {
	@Autowired
	RestaurantRepo restaurantRepo;
	public List<Restaurant> findAllRestaurants() {
		return restaurantRepo.findAll();
		
	}
	public Restaurant saveRestaurant(Restaurant restaurant) {
		Restaurant saved = restaurantRepo.save(restaurant);
		return saved;
	}
	public ResponseEntity<Restaurant> getRestaurant(Integer id) {
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		if(restaurant.get()!=null) {
			return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
