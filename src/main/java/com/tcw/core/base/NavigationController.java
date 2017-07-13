package com.tcw.core.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcw.core.anno.NoValidateLoginAuth;

@Controller
public class NavigationController {
	
	private String prePath = "html";
	
	@RequestMapping("/")
	@NoValidateLoginAuth
	public ModelAndView login() {
		return new ModelAndView(prePath + "/login.html");
	}
	
	@RequestMapping("/main") 
	public ModelAndView main() {
		return new ModelAndView(prePath + "/main.html");
	}

	@RequestMapping("/load")
	public ModelAndView load(String htmlFile) {
		return new ModelAndView(prePath + "/" + htmlFile);
	}
}
