package org.mystudy.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("appController")
public class AppController {

	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView("admin");
		return model;
	}
	@RequestMapping("/user")
	public ModelAndView user() {
		ModelAndView model = new ModelAndView("user");
		return model;
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
}
