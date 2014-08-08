package api;

import java.util.List;

import models.LocationModel;
import models.Template;

public interface ApiService {
	
	public List<Template> getTemplates();

	public boolean postCheckin(String user, int id);
	
	public List<LocationModel> getLocations(double latitude, double longitude, String type);
}
