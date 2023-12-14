package com.distributedcomputing.restaurantlisting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.distributedcomputing.restaurantlisting.entity.Restaurant;
@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

}
