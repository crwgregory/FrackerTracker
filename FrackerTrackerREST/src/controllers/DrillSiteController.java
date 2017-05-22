package controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.DrillSiteDAO;

@RestController
@RequestMapping("/drillsites")

public class DrillSiteController {
	@Autowired 
	private DrillSiteDAO dsDAO;
	
	@PersistenceContext
	private EntityManager em;
	
	@RequestMapping(value = "/drillsites/ping", method = RequestMethod.GET)
	public String ping(){
		return "PONG FROM DRILLSITE CONTROLLER";
	}
}
