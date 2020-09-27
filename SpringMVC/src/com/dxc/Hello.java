package com.dxc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Hello extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView modelAndView=new ModelAndView("HelloPage");
		modelAndView.addObject("msg", "Hello world");
		return modelAndView;
	}
	
}

