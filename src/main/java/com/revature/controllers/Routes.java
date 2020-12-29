package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.FoodDAO;
import com.revature.DAO.FoodDAOimp;
import com.revature.models.Food;

public class Routes{
	private static FoodDAO fd = new FoodDAOimp();
	private static ObjectMapper om = new ObjectMapper();
	
	

	public static void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Routes.doGet has been pinged.");
		System.out.println(fd.foodList);
		if(req.getMethod().equals("GET")) {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		Food food = fd.getFood(id);
		resp.setContentType("application/json");
		resp.getWriter().write(om.writeValueAsString(food));
		} else {
			resp.setStatus(405);
		}
	}
	
	public static void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		
		ObjectMapper om = new ObjectMapper();
		
		Food p1 = om.readValue(req.getReader(), com.revature.models.Food.class);
		
		foodList.add(p1);

		resp.getWriter().write(om.writeValueAsString(foodList));

		
	}

	
	public static void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Food Food1 = new Food("Celery", 1.99);
		Food Food2 = new Food("Mango", 3.99);
		Food Food3 = new Food("Apple", 0.99);
		
		foodList.add(Food1);
		foodList.add(Food2);
		foodList.add(Food3);
		
		resp.setContentType("application/json");
		
		int foodId = Integer.parseInt(req.getParameter("id"));
		
		ObjectMapper om = new ObjectMapper();
		
		Food p1 = om.readValue(req.getReader(), com.revature.models.Food.class);
		
		foodList.remove(foodId);
		foodList.add(foodId, p1);
		
		resp.getWriter().write(om.writeValueAsString(foodList));
		
	}
	
	public static void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Food Food1 = new Food("Celery", 1.99);
		Food Food2 = new Food("Mango", 3.99);
		Food Food3 = new Food("Apple", 0.99);
		
		foodList.add(Food1);
		foodList.add(Food2);
		foodList.add(Food3);
		
		resp.setContentType("application/json");
		
		int foodId = Integer.parseInt(req.getParameter("id"));
		
		foodList.remove(foodId);
		
		ObjectMapper om = new ObjectMapper();
		
		resp.getWriter().write(om.writeValueAsString(foodList));
	
		
	}

	
}
