package api;

import java.util.ArrayList;
import java.util.List;

import models.LocationModel;
import models.Template;

public class MockApiService implements ApiService {

	@Override
	public List<Template> getTemplates() {
		List<Template> templates = new ArrayList<Template>();
		Template t1 = new Template();
		t1.setId(1);
		t1.setText("Police alert");
		Template t2 = new Template();
		t2.setId(1);
		t2.setText("Breathalyzer check alert");
		templates.add(t1);
		templates.add(t2);
		return templates;
	}

	@Override
	public boolean postCheckin(String user, int id) {
		System.out.println(user + " " + id);
		return true;
	}

	@Override
	public List<LocationModel> getLocations(double latitude, double longitude, String type) {
		List<LocationModel> models = new ArrayList<LocationModel>();
		LocationModel model1 = new LocationModel();
		model1.setLatitude(latitude - 0.005);
		model1.setLongitude(longitude - 0.005);
		LocationModel model2 = new LocationModel();
		model2.setLatitude(latitude - 0.005);
		model2.setLongitude(longitude + 0.005);
		LocationModel model3 = new LocationModel();
		model3.setLatitude(latitude + 0.005);
		model3.setLongitude(longitude - 0.005);
		LocationModel model4 = new LocationModel();
		model4.setLatitude(latitude + 0.005);
		model4.setLongitude(longitude + 0.005);
		models.add(model1);
		models.add(model2);
		models.add(model3);
		models.add(model4);
		return models;
	}
	
}
