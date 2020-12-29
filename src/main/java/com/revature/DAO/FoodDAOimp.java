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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateFood(Food food) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteFood(Food food) {
		// TODO Auto-generated method stub
		
	}
	
	
}
