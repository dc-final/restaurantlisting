package com.distributedcomputing.restaurantlisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.distributedcomputing.restaurantlisting.entity.Restaurant;
import com.distributedcomputing.restaurantlisting.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/allRestaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurants(){
		List<Restaurant> allRestaurants = restaurantService.findAllRestaurants();
		return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
	}
	@PostMapping("/saveRestaurant")
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant){
		Restaurant restaurantSaved = restaurantService.saveRestaurant(restaurant);
		return new ResponseEntity<>(restaurantSaved, HttpStatus.CREATED);
	}
	@GetMapping("/getRestaurant/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Integer id){
		return restaurantService.getRestaurant(id);
	}

}
