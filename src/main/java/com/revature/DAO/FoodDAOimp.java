package com.revature.DAO;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Food;

public class FoodDAOimp implements FoodDAO{
	
public List<Food> foodList = new ArrayList<Food>();
	
	public FoodDAOimp()
	{
		Food Food1 = new Food("Celery", 1.99);
		Food Food2 = new Food("Mango", 3.99);
		Food Food3 = new Food("Apple", 0.99);
		foodList.add(Food1);
		foodList.add(Food2);
		foodList.add(Food3);
	}
	
	public Food getFood(int id) {
		Food food = foodList.get(id);
		return food;
	}


	@Override
	public void createFood(Food food) {
		Food Food4 = new Food(food.getName(), food.getPrice());
		foodList.add(Food4);

	}


	@Override
	public void updateFood(Food food, Food newFood) {
		
		deleteFood(food);
		createFood(newFood);
		
		
	}


	@Override
	public void deleteFood(Food food) {
		
		foodList.remove(foodList.indexOf(food));
	}
	
	
}
