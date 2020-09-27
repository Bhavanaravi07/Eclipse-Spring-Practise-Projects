package com.dxc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HiController {
	
	@RequestMapping("hi")
	public String helloAction(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		return "hi";
	}

}
