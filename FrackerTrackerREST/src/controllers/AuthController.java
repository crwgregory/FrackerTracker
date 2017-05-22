package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.AuthDAO;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthDAO authDAO;
	
	@RequestMapping(value="/ping", method = RequestMethod.GET)
	public String ping(){
		return "PONG FROM AUTH CONTROLLER!";
	}
}
