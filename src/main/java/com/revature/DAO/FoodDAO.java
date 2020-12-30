package com.revature.DAO;

import java.util.List;

import com.revature.models.Food;

public interface FoodDAO {
	List<Food> foodList = null;
	public Food getFood(int id);
	public void createFood(Food food);
	public void deleteFood(Food food);
	public void updateFood(Food food, Food newFood);
}
