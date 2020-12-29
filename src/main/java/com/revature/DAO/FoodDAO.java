package com.revature.DAO;

import com.revature.models.Food;

public interface FoodDAO {
	Food[] foodList = null;
	public Food getFood(int id);
	public void createFood(Food food);
	public void updateFood(Food food);
	public void deleteFood(Food food);
}
