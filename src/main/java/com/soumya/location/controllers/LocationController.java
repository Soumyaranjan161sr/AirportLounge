package com.soumya.location.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soumya.location.entities.Location;
import com.soumya.location.services.LocationService;
import com.soumya.location.util.EmailUtil;

import antlr.collections.List;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	@Autowired
    EmailUtil emailUtil;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelmap)
	{
		Location locationSaved = service.saveLocation(location);
		String msg = "location saved with id:" + locationSaved.getId();
		modelmap.addAttribute("msg", msg);
		emailUtil.sentEmail("azyx1470@gmail.com", "Location Saved",
						"Location Saved Successfully and about to return a response");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelmap)
	{
		java.util.List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("locations" , locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocations")
	public String deleteLocations(int id)
	{
		return "displayLocations";
	}
	
	@RequestMapping("deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		// Location location = service.getLocationById(id);
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		java.util.List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationbyID(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		java.util.List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

}
