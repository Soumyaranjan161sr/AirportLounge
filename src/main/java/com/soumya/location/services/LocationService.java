package com.soumya.location.services;

import java.util.List;

import com.soumya.location.entities.Location;

public interface LocationService {
	
	Location saveLocation(Location location);
	Location updateLocation(Location location);
	void deleteLocation(Location location);
	Location getLocationbyID( int id);
	List<Location> getAllLocations();

}
