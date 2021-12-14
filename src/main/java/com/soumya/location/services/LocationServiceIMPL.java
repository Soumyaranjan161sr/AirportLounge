package com.soumya.location.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumya.location.entities.Location;
import com.soumya.location.repos.LocationRepository;
@Service
public class LocationServiceIMPL implements LocationService {
	@Autowired
	private LocationRepository repository;

	@Override
	public Location saveLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repository.save(location);
	}

	public void deleteLocation(Location location) {
            repository.delete(location);
	}

	@Override
	public Location getLocationbyID(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		return repository.findAll();
	}

}
