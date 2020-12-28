package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.FoodDriver;
import com.revature.models.Food;

@WebServlet("/test")
public class Routes extends HttpServlet {
	
	public static List<Food> foodList = new ArrayList<Food>();
	
	Food Food1 = new Food("Celery", 1.99);
	Food Food2 = new Food("Mango", 3.99);
	Food Food3 = new Food("Apple", 0.99);
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		foodList.add(Food1);
		foodList.add(Food2);
		foodList.add(Food3);
		
		int foodId = Integer.parseInt(req.getParameter("id"));
				
		Food foodName = foodList.get(foodId);

		PrintWriter pw = resp.getWriter();
		
		pw.write("Here's the Food: " + foodName);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		
		ObjectMapper om = new ObjectMapper();
		
		Food p1 = om.readValue(req.getReader(), com.revature.models.Food.class);
		
		foodList.add(p1);

		resp.getWriter().write(om.writeValueAsString(foodList));

		
	}

	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
