package com.dxc.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showForm()  {
		return "form1";
	}
	
	@RequestMapping(value = "showName" , method = RequestMethod.POST)
	//public String showName(HttpServletRequest req , HttpServletResponse res) {
		//String devName = req.getParameter("devName");
		//HttpSession session = req.getSession();
		//session.setAttribute("name", devName);
		//return "dispName";
	
	//public String showName(String devName, HttpSession session) {
		//session.setAttribute("name", devName);
		//return "dispName";
		
    public ModelAndView showName(@RequestParam("devName") String name, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName("dispName");
        return modelAndView;
    }
		
	}

