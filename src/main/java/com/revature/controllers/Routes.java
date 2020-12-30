package com.revature.controllers;

import java.io.IOException;
import java.util.List;

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
		
		System.out.println("Routes.doPost has been pinged.");
		System.out.println(fd.foodList);
		if(req.getMethod().equals("POST")) {
		
//		int id = Integer.parseInt(req.getParameter("id"));
			resp.setContentType("application/json");

			Food food = om.readValue(req.getReader(), com.revature.models.Food.class);
			fd.createFood(food);
			
			resp.setStatus(200);
			} else {
				resp.setStatus(400);
			}
			
	}
	

	
	public static void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Route doPut is getting pinged");

		resp.setContentType("application/json");
		int foodId = Integer.parseInt(req.getParameter("id"));
		Food food = fd.getFood(foodId);
				
		Food p1 = om.readValue(req.getReader(), com.revature.models.Food.class);
		
		if(req.getMethod().equals("PUT")) {

			fd.updateFood(food, p1);
			resp.setStatus(200);

		}else {
			resp.setStatus(404);
		}
					
	}
	
	
	public static void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Route doDelete is getting pinged");

		
		resp.setContentType("application/json");
		
		int foodId = Integer.parseInt(req.getParameter("id"));
		Food food = fd.getFood(foodId);
		
//		List<Food> food = fd.foodList;
		
		if(req.getMethod().equals("DELETE")) {
			
			System.out.println(food);

			fd.deleteFood(food);
			
			
			
//			ObjectMapper om = new ObjectMapper();
//			resp.getWriter().write(om.writeValueAsString(fd.foodList));
			
		}else {
			resp.setStatus(404);
		}

		
		

		

	
		
	}

	
}
