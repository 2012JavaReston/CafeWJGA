package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Food;

public class FoodDriver {
	
	public static List<Food> foodList = new ArrayList<Food>();
	
	public static void main(String[] args) {
		
		
		Food Food1 = new Food("Celery", 1.99);
		Food Food2 = new Food("Mango", 3.99);
		Food Food3 = new Food("Apple", 0.99);
		
		foodList.add(Food1);
		foodList.add(Food2);
		foodList.add(Food3);
		foodList.forEach(e -> System.out.println(e));
	}
}
