package cn.com.widemex.streetDiscount.shopPlatform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/errors")
public class ExceptionController extends BaseController {
	
	
	@RequestMapping(value="accessDenied.jspx")
	public String accessDenied(HttpServletRequest request, Model model){
		return "errors/accessDenied";
	}
	
	
	@RequestMapping(value="sessionExpired.jspx")
	public String sessionExpired(HttpServletRequest request, Model model){		
		return "errors/sessionExpired";
	}

}
