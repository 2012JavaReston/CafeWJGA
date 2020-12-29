package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public static void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String endpoint = req.getRequestURI();
		
	switch(endpoint)

	{
	case "/CafeWebo/cafe/menu":
		switch(req.getMethod()){
			case "GET":
				System.out.println("ReqHelper is getting pinged.");
				Routes.doGet(req, resp);
				break;
			case "POST":
				Routes.doPost(req, resp);
				break;
			case "PUT":
				Routes.doPut(req, resp);
				break;
			case "DELETE":
				Routes.doDelete(req, resp);
				break;
		}
		break;
	case "/login":
		
		
		break;
	default:
		System.out.println("no case selected");
		break;
	}
	}
}
