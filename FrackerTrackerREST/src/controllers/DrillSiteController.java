package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.DrillSiteDAO;
import entities.DrillSite;

@RestController

public class DrillSiteController {
	@Autowired 
	private DrillSiteDAO dsDAO;
	
	@PersistenceContext
	private EntityManager em;
	
	@RequestMapping(value = "/drillsites/ping", method = RequestMethod.GET)
	public String ping(){
		System.out.println("test");
		return "PONG FROM DRILLSITE CONTROLLER";
	}
	
	//shows list of drillsites
	@RequestMapping(value="/drillsites", method = RequestMethod.GET)
	public List <DrillSite> index(){
		return dsDAO.index();
	}
	//gets an individual site		
	@RequestMapping(value = "/drillsites/{id}", method = RequestMethod.GET)
	public DrillSite viewSite(@PathVariable int id){
		return dsDAO.show(id);
	}
	//updates an existing site
	@RequestMapping(value = "/drillsites/{id}", method = RequestMethod.PUT)
	public DrillSite update(@PathVariable int id, @RequestBody String updateSite, HttpServletResponse res){
	System.out.println(updateSite);
	try{
		ObjectMapper mapper = new ObjectMapper();
		DrillSite mappedDS = mapper.readValue(updateSite, DrillSite.class);
		res.setStatus(201);
		return dsDAO.create(mappedDS);
	}catch(Exception e){
		System.out.println("SITE FAILED TO UPDATE");
		e.printStackTrace();
	}
	return null;
}

	//creates a drill site
	@RequestMapping(value = "/drillsites", method = RequestMethod.POST)
	public DrillSite create(DrillSite ds, @RequestBody String jsonDrillSite, HttpServletResponse res){
		
		System.out.println(jsonDrillSite);
		try{
			ObjectMapper mapper = new ObjectMapper();
			DrillSite mappedDS = mapper.readValue(jsonDrillSite, DrillSite.class);
			res.setStatus(201);
			return dsDAO.create(mappedDS);
		}catch(Exception e){
			System.out.println("SITE FAILED TO CREATE");
			e.printStackTrace();
		}
		return null;
	}
	
	//removes a drill site
	@RequestMapping(value = "/drillsites/{id}", method = RequestMethod.DELETE)
	public boolean deleteSite(@PathVariable int id){
		return dsDAO.remove(id);
	}
}
